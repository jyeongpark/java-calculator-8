package calculator.constants;

public class Constants {
    public static final String CUSTOM_SEPARATOR_REGEX = "//(.*?)\\\\n";
    public static final String CANDIDATE_SEPARATOR_REGEX = "(?<!\\d)\\.(?!\\d)|[^0-9.]";
    public static final String POSITIVE_NUMBER_REGEX = "^[1-9]\\d*(\\.\\d+)?$";
    public static final String END_WITH_NUMBER_REGEX = ".*\\d$";
    public static final String NUMBER_ONLY_REGEX = "^[0-9]+$";
    public static final String BLANK = "";
    public static final String OR = "|";
}