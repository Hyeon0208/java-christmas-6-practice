package christmas;

import christmas.controller.PromotionController;
import christmas.view.ErrorView;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = initHandler();
        OutputView outputView = new OutputView();
        PromotionController controller = new PromotionController(inputHandler, outputView);
        controller.start();
    }

    private static InputHandler initHandler() {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        return new InputHandler(inputView, errorView);
    }
}
