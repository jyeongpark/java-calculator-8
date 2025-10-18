package calculator.enums;

import java.util.Arrays;

public enum DefaultSeparator {

    COMMA(","),
    COLON(":");

    private final String value;

    DefaultSeparator(String value) {
        this.value = value;
    }

    public static boolean isDefaultSeparator(String value) {
        return Arrays.stream(DefaultSeparator.values())
                .anyMatch(separator -> separator.value.equals(value));
    }

    public static boolean isNotDefaultSeparator(String value) {
        return !isDefaultSeparator(value);
    }
}
