package br.com.alteia.microservicechangeit.use_cases.common.utils;

import br.com.alteia.microservicechangeit.common.exceptions.InvalidEntityException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static br.com.alteia.microservicechangeit.use_cases.common.utils.EntityFieldsValidations.ONLY_LETTERS_PATTERN;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EntityFieldsValidationsUTest {

    @Nested
    class validateStandardizedSizedString {
        @Test
        void standardizedSizedStringSucess() {
            String value = "teste field";
            assertDoesNotThrow(() -> EntityFieldsValidations.standardizedSizedString("name", value, 1, 100));
        }

        @Test
        void standardizedSizedStringMinLenghtError() {
            String value = "teste field";
            assertThrows(InvalidEntityException.class, () -> EntityFieldsValidations.standardizedSizedString("name", value, ONLY_LETTERS_PATTERN, 50, 100));
        }

        @Test
        void standardizedSizedStringMaxLenghtError() {
            String value = "teste field";
            assertThrows(InvalidEntityException.class, () ->
                    EntityFieldsValidations.standardizedSizedString(
                            "name", value, ONLY_LETTERS_PATTERN, 1, 5)
            );
        }
    }

    @Nested
    class validateStandardizedPatternedString {
        @Test
        void standardizedSizedStringWithPatternSucess() {
            String value = "teste field";
            assertDoesNotThrow(() -> EntityFieldsValidations.standardizedSizedString("name", value, ONLY_LETTERS_PATTERN, 1, 100));
        }

        @Test
        void standardizedSizedStringWithPatternError() {
            String value = "teste field1";
            assertThrows(InvalidEntityException.class,
                    () -> EntityFieldsValidations.standardizedSizedString(
                            "name", value, ONLY_LETTERS_PATTERN, 1, 100)
            );
        }
    }

    @Nested
    class validateNotNull {
        @Test
        void notNullStringSucess() {
            String value = "teste field";
            assertDoesNotThrow(() -> EntityFieldsValidations.notNull(
                    "name", value)
            );
        }

        @Test
        void notNullStringError() {
            String value = null;
            assertThrows(InvalidEntityException.class,
                    () -> EntityFieldsValidations.notNull(
                            "name", value)
            );
        }
    }

    @Nested
    class validateMinLength {

        @Test
        void minLengthAsExpected() {
            assertDoesNotThrow(() -> EntityFieldsValidations.minValue("value", 100, 1));
        }

        @Test
        void minLengthAsNotExpected() {
            assertThrows(InvalidEntityException.class, () -> EntityFieldsValidations.minValue("value", -100, 1));
        }
    }
}