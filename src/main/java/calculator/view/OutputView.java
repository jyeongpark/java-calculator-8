package calculator.view;

import calculator.enums.Message;

public class OutputView {
    public static void printCalculateResult(Number result) {
        if (result.doubleValue() % 1 == 0) {
            System.out.println(Message.RESULT.getValue() + result.intValue());
            return;
        }
        System.out.println(Message.RESULT.getValue() + result.doubleValue());
    }
}
