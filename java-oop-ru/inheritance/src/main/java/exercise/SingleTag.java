package exercise;

import java.util.Map;
import java.util.StringJoiner;

// BEGIN
public class SingleTag extends Tag{

    public SingleTag(String name,Map<String,String> tagAttributes){
        super(name,tagAttributes);
    }

    @Override
    public String toString() {
        // Начинаем формировать строку с открывающего тега
        StringBuilder builder = new StringBuilder("<" + name);

        // Если у тега есть атрибуты, добавляем их
        if (tagAttributes != null && !tagAttributes.isEmpty()) {
            for (Map.Entry<String, String> entry : tagAttributes.entrySet()) {
                builder.append(" ")
                        .append(entry.getKey())
                        .append("=\"")
                        .append(entry.getValue())
                        .append("\"");
            }
        }

        // Закрываем тег
        builder.append(">");

        // Возвращаем полное строковое представление тега
        return builder.toString();
    }
}
// END
