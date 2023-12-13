package christmas.view;

public class ErrorView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String DATE_INPUT_ERROR = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String ORDER_INPUT_ERROR = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}