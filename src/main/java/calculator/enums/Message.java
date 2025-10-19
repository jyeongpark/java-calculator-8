package calculator.enums;

public enum Message {
    ONLY_POSITIVE("양수만 계산할 수 있어요."),
    NOT_FOUND_SEPARATOR("구분자를 찾을 수 없어요. 구분자를 입력해주세요."),
    ONLY_ONE_CHARACTER("구분자는 한 글자만 사용할 수 있어요."),
    NOT_ALLOWED_NUMBER("구분자는 숫자가 될 수 없어요."),
    NOT_ALLOWED_SEPARATOR("사용할 수 없는 구분자에요."),
    NOT_ALLOWED_CUSTOM_SEPARATOR("기본 구분자는 커스텀 구분자가 될 수 없어요."),
    NOT_END_WITH_NUMBER("입력은 숫자로 끝나야해요."),
    EMPTY_INPUT("입력이 비어있어요."),
    INPUT("덧셈할 문자열을 입력해 주세요."),
    RESULT("결과 : ");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
