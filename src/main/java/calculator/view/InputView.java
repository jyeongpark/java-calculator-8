package calculator.view;

import calculator.constants.Constants;
import calculator.enums.Message;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(Constants.CUSTOM_SEPARATOR_REGEX);
    private static final Pattern CANDIDATE_SEPARATOR_PATTERN = Pattern.compile(Constants.CANDIDATE_SEPARATOR_REGEX);

    public static String inputValue() {
        System.out.println(Message.INPUT.getValue());
        return Console.readLine();
    }

    public static String extractCustomSeparator(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static List<String> extractCandidateSeparators(String input) {
        String expression = extractExpression(input);

        if (!expression.matches(Constants.END_WITH_NUMBER_REGEX)) {
            throw new IllegalArgumentException(Message.NOT_END_WITH_NUMBER.getValue());
        }

        Matcher candidateMatcher = CANDIDATE_SEPARATOR_PATTERN.matcher(expression);
        List<String> result = new ArrayList<>();

        while (candidateMatcher.find()) {
            result.add(candidateMatcher.group());
        }

        return result;
    }

    public static String extractExpression(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT.getValue());
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if (matcher.find()) {
            return input.replaceAll(Constants.CUSTOM_SEPARATOR_REGEX, Constants.BLANK);
        }

        return input;
    }
}
