package calculator.model;

import calculator.constants.Constants;
import calculator.enums.ForbiddenSeparator;
import calculator.enums.Message;

public class Separator {
    private final String value;

    public Separator(String value) {
        validateSeparator(value);
        this.value = value;
    }

    private void validateSeparator(String separator) {
        if (separator == null || separator.isEmpty()) {
            throw new IllegalArgumentException(Message.NOT_FOUND_SEPARATOR.getValue());
        }

        if (separator.length() != 1) {
            throw new IllegalArgumentException(Message.ONLY_ONE_CHARACTER.getValue());
        }

        if (separator.matches(Constants.NUMBER_ONLY_REGEX)) {
            throw new IllegalArgumentException(Message.NOT_ALLOWED_NUMBER.getValue());
        }

        if (ForbiddenSeparator.isForbiddenSeparator(separator)) {
            throw new IllegalArgumentException(Message.NOT_ALLOWED_SEPARATOR.getValue());
        }
    }

    public String getValue() {
        return this.value;
    }
}
