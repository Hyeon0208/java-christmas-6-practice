package christmas.controller;

import christmas.view.OutputView;
import christmas.view.handler.InputHandler;

public class PromotionController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public PromotionController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printGreetingMessage();
        outputView.printVisitDateInputMessage();
        int visitDate = inputHandler.receiveValidatedVisitDate();

        outputView.printOrderInputMessage();
        String orderMenus = inputHandler.receiveValidatedOrderMenus();
    }
}
