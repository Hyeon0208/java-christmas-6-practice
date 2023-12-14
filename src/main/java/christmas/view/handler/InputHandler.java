package christmas.view.handler;

import christmas.util.StringConvertor;
import christmas.view.ErrorView;
import christmas.view.InputView;
import java.util.function.Supplier;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public int receiveValidatedVisitDate() {
        String visitDate = receiveValidatedInput(inputView::inputVisitDate);
        return StringConvertor.convertToInt(visitDate);
    }

    public String receiveValidatedOrderMenus() {
        return receiveValidatedInput(inputView::inputOrderMenus);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
