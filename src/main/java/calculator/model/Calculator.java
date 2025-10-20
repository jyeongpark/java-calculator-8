package calculator.model;

import java.util.List;

public class Calculator {
    private final List<PositiveNumber> numbers;

    public Calculator(List<PositiveNumber> numbers) {
        this.numbers = numbers;
    }

    public PositiveNumber sum() {
        return numbers.stream()
                .reduce(PositiveNumber.identity(), PositiveNumber::add);
    }
}
