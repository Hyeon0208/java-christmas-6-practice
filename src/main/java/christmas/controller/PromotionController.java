package christmas.controller;

import christmas.domain.event.Badge;
import christmas.domain.event.EventApplicator;
import christmas.domain.user.Orders;
import christmas.domain.user.User;
import christmas.domain.user.VisitDate;
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
        User user = setUpUser();
        showUserBenefitPreview(user);
        showReceivedBadge(user);
    }

    private User setUpUser() {
        VisitDate visitDate = setUpVisitDate();
        Orders orders = setUpOrders();
        return new User(orders, visitDate);
    }

    private VisitDate setUpVisitDate() {
        outputView.printVisitDateInputMessage();
        return VisitDate.from(inputHandler.receiveValidatedVisitDate());
    }

    private Orders setUpOrders() {
        outputView.printOrderInputMessage();
        String orderMenus = inputHandler.receiveValidatedOrderMenus();
        return Orders.from(orderMenus);
    }

    private void showUserBenefitPreview(User user) {
        outputView.printBenefitPreviewMessage();
        outputView.printOrdersHistory(user);
        outputView.printTotalOrderPrice(user);
        EventApplicator.apply(user);
        outputView.printGiftMenu(user);
        outputView.printAppliedEvent(user);
        outputView.printTotalBenefitPrice(user);
        outputView.printActualPaymentPrice(user);
    }

    private void showReceivedBadge(User user) {
        String badgeName = Badge.getBadgeBasedOnConditions(user);
        outputView.printBadge(badgeName);
    }
}
