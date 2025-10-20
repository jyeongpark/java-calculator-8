package calculator.controller;

import calculator.model.Calculator;
import calculator.model.PositiveNumber;
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
        List<PositiveNumber> numbers = parseNumbers(expression, separators);
        PositiveNumber result = new Calculator(numbers).sum();
        OutputView.printCalculateResult(result);
    }

    private List<PositiveNumber> parseNumbers(String expression, Separators separators) {
        String[] tokens = expression.split(separators.getSplitRegex());
        return Arrays.stream(tokens)
                .map(String::trim)
                .map(PositiveNumber::new)
                .toList();
    }
}
