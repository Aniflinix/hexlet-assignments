package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions.*;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testSuccessfulValidation() {
        Address address = new Address("USA", "New York", "Broadway", "123", "45");
        Map<String, List<String>> errors = Validator.advancedValidate(address);
        assertTrue(errors.isEmpty(), "Validation errors should be empty for valid input");
    }
    @Test
    void testNotNullValidation() {
        Address address = new Address(null, "New York", "Broadway", "123", "45");
        Map<String, List<String>> errors = Validator.advancedValidate(address);

        assertFalse(errors.isEmpty(), "Validation errors should not be empty");
        assertTrue(errors.containsKey("country"), "Errors should include 'country'");
        assertTrue(errors.get("country").contains("country cannot be null"));
    }


    @Test
    void testFieldsWithoutAnnotations() {
        Address address = new Address("USA", "New York", "Broadway", "123", null);
        Map<String, List<String>> errors = Validator.advancedValidate(address);

        assertFalse(errors.containsKey("flatNumber"), "Errors should not include 'flatNumber'");
    }
    @Test
    void testAllFieldsNull() {
        Address address = new Address(null, null, null, null, null);
        Map<String, List<String>> errors = Validator.advancedValidate(address);

        assertFalse(errors.isEmpty(), "Validation errors should not be empty");
        assertTrue(errors.containsKey("country"), "Errors should include 'country'");
        assertTrue(errors.containsKey("city"), "Errors should include 'city'");
        assertTrue(errors.containsKey("street"), "Errors should include 'street'");
        assertTrue(errors.containsKey("houseNumber"), "Errors should include 'houseNumber'");
    }

    // END
}
