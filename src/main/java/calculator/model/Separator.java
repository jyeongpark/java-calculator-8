package calculator.model;

import calculator.constants.Constants;
import calculator.enums.DefaultSeparator;
import calculator.enums.ForbiddenSeparator;

public class Separator {
    private final String value;

    public Separator(String value) {
        validateSeparator(value);
        this.value = value;
    }

    private void validateSeparator(String separator) {
        if (separator == null || separator.isEmpty()) {
            throw new IllegalArgumentException("구분자를 찾을 수 없어요. 구분자를 입력해주세요.");
        }

        if (separator.length() != 1) {
            throw new IllegalArgumentException("구분자는 한 글자만 사용할 수 있어요.");
        }

        if (separator.matches(Constants.NUMBER_ONLY_REGEX)) {
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없어요.");
        }

        if (ForbiddenSeparator.isForbiddenSeparator(separator)) {
            throw new IllegalArgumentException("사용할 수 없는 입력자에요.");
        }

        if (DefaultSeparator.isDefaultSeparator(separator)) {
            throw new IllegalArgumentException("기본 입력자는 커스텀 구분자가 될 수 없어요.");
        }
    }

    public String getValue() {
        return this.value;
    }
}
