package calculator.view;

public class OutputView {
    public static void printCalculateResult(Number result) {
        if (result.doubleValue() % 1 == 0) {
            System.out.println("결과 : " + result.intValue());
            return;
        }
        System.out.println("결과 : " + result.doubleValue());
    }
}
