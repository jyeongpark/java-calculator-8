package calculator.controller;

import calculator.constants.Constants;
import calculator.model.Calculator;
import calculator.model.Separators;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {
    public void startCalculate() {
        String inputValue = InputView.inputValue();
        String customSeparator = InputView.extractCustomSeparator(inputValue);
        List<String> candidateSeparators = InputView.extractCandidateSeparators(inputValue);
        Separators separators = customSeparator.isEmpty()
                ? new Separators(candidateSeparators)
                : new Separators(candidateSeparators, customSeparator);
        String expression = InputView.extractExpression(inputValue);
        List<Double> numbers = parseNumbers(expression, separators);
        double result = new Calculator(numbers).sum();
        OutputView.printCalculateResult(result);
    }

    private List<Double> parseNumbers(String expression, Separators separators) {
        String[] tokens = expression.split(separators.getSplitRegex());
        return Arrays.stream(tokens)
                .map(String::trim)
                .map(this::convertToStringToDouble)       // 숫자 + 양수 검증
                .toList();
    }

    private Double convertToStringToDouble(String value) {
        validatePositiveNumber(value);
        return Double.parseDouble(value);
    }

    private void validatePositiveNumber(String value) {
        if (value.isEmpty() || !value.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("양수만 계산할 수 있어요.");
        }
    }
}
