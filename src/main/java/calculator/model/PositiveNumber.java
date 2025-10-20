package calculator.model;

import calculator.constants.Constants;
import calculator.enums.Message;
import java.math.BigDecimal;

public class PositiveNumber {
    private final double value;

    public PositiveNumber(String value) {
        validatePositiveNumber(value);
        this.value = Double.parseDouble(value);
    }

    public PositiveNumber(double value) {
        validatePositiveNumber(value);
        this.value = value;
    }

    private void validatePositiveNumber(String value) {
        if (value.isEmpty() || !value.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(Message.ONLY_POSITIVE.getValue());
        }

        if (Double.isInfinite(Double.parseDouble(value))) {
            throw new IllegalArgumentException(Message.TOO_LARGE_NUMBER.getValue());
        }
    }

    private void validatePositiveNumber(double value) {
        if (value <= 0.0) {
            throw new IllegalArgumentException(Message.ONLY_POSITIVE.getValue());
        }

        if (Double.isInfinite(value)) {
            throw new IllegalArgumentException(Message.TOO_LARGE_NUMBER.getValue());
        }
    }

    public PositiveNumber add(PositiveNumber other) {
        return new PositiveNumber(this.value + other.value);
    }

    public static PositiveNumber identity() {
        return new PositiveNumber(Double.MIN_VALUE);
    }

    public String getFormattedValue() {
        return BigDecimal.valueOf(value)
                .stripTrailingZeros()
                .toPlainString();
    }

    @Override
    public String toString() {
        return getFormattedValue();
    }
}
