package calculator.model;

import java.util.List;

public class Calculator {
    private final List<Double> numbers;
    private double sum;

    public Calculator(List<Double> numbers) {
        this.numbers = numbers;
        this.sum = 0.0;
    }

    public double sum() {
        numbers.forEach(number -> sum += number);
        return sum;
    }
}
