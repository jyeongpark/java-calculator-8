package calculator.model;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> numbers;
    private int sum;

    public Calculator() {
    }

    public Calculator(ArrayList<Integer> numbers) {
        this.numbers = numbers;
        this.sum = 0;
    }

    public Integer getSum() {
        numbers.forEach(number -> sum += number);
        return sum;
    }

}
