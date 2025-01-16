package exercise;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import  java.util.Map;
import java.util.List;

// BEGIN
public class Validator {

    public static ArrayList<String> validate(Object obj) {
        ArrayList<String> invalidFields = new ArrayList<>();


        Class<?> clazz = obj.getClass();


        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Unable to access field: " + field.getName(), e);
                }
            }
        }

        return invalidFields;

    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> validationErrors = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            List<String> errors = new ArrayList<>();
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (value == null) {
                        errors.add(field.getName() + " cannot be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                int minLength = minLengthAnnotation.minLength();

                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);

                    if (value instanceof String) {
                        String strValue = (String) value;
                        if (strValue.length() < minLength) {
                            errors.add(field.getName() + " must have at least " + minLength + " characters");
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


            if (!errors.isEmpty()) {
                validationErrors.put(field.getName(), errors);
            }
        }

        return validationErrors;
    }
}

// END
