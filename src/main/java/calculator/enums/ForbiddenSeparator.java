package calculator.enums;

import java.util.Arrays;

public enum ForbiddenSeparator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    DOT(".");

    private final String value;

    ForbiddenSeparator(String value) {
        this.value = value;
    }

    public static boolean isForbiddenSeparator(String value) {
        return Arrays.stream(ForbiddenSeparator.values())
                .anyMatch(separator -> separator.value.equals(value));
    }
}
