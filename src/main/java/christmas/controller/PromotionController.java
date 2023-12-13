package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.User;
import christmas.domain.VisitDate;
import christmas.domain.event.Badge;
import christmas.domain.event.EventApplicator;
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
        VisitDate visitDate = VisitDate.from(inputHandler.receiveValidatedVisitDate());

        outputView.printOrderInputMessage();
        String orderMenus = inputHandler.receiveValidatedOrderMenus();

        Orders orders = Orders.from(orderMenus);
        User user = new User(orders, visitDate);

        outputView.printBenefitPreviewMessage();
        outputView.printOrdersHistory(orders);
        outputView.printTotalOrderPrice(orders);

        EventApplicator.apply(user);
        outputView.printGiftMenu(user);
        outputView.printAppliedEvent(user);
        outputView.printTotalBenefitPrice(user);
        outputView.printActualPaymentPrice(user);

        String badgeName = Badge.getBadgeBasedOnConditions(user);
        outputView.printBadge(badgeName);
    }
}
