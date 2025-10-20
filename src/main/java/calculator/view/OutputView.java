package calculator.view;

import calculator.enums.Message;
import calculator.model.PositiveNumber;

public class OutputView {
    public static void printCalculateResult(PositiveNumber result) {
        System.out.println(Message.RESULT.getValue() + result.toString());
    }
}
