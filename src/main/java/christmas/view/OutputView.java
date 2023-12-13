package christmas.view;

import christmas.domain.event.EventInfo;
import christmas.domain.user.OrderInfo;
import christmas.domain.user.Orders;
import christmas.domain.user.User;

public class OutputView {

    public void printGreetingMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printVisitDateInputMessage() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void printOrderInputMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printBenefitPreviewMessage() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printNewLine();
    }

    public void printOrdersHistory(Orders orders) {
        StringBuilder orderHistory = new StringBuilder();
        orderHistory.append("<주문 메뉴>").append("\n");
        for (OrderInfo order : orders.getOrders()) {
            orderHistory.append(String.format("%s %d개\n", order.getName(), order.getCount()));
        }
        System.out.println(orderHistory);
    }

    public void printTotalOrderPrice(Orders orders) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", orders.getTotalOrderPrice());
        printNewLine();
    }

    public void printGiftMenu(User user) {
        System.out.println("<증정 메뉴>");
        if (user.isReceiveGift()) {
            System.out.printf("%s %d개\n", "샴페인", 1);
        }
        if (!user.isReceiveGift()) {
            System.out.println("없음");
        }
        printNewLine();
    }

    public void printAppliedEvent(User user) {
        System.out.println("<혜택 내역>");
        if (user.notAppliedEvent()) {
            System.out.println("없음");
            printNewLine();
        }
        if (!user.notAppliedEvent()) {
            StringBuilder appliedEvent = new StringBuilder();
            for (EventInfo eventInfo : user.getAppliedEventInfos()) {
                appliedEvent.append(String.format("%s: -%,d원", eventInfo.name(), eventInfo.discount()))
                        .append("\n");
            }
            System.out.println(appliedEvent);
        }
    }

    public void printTotalBenefitPrice(User user) {
        System.out.println("<총혜택 금액>");
        if (user.getTotalBenefit() == 0) {
            System.out.println("0원");
        }
        if (user.getTotalBenefit() > 0) {
            System.out.printf("-%,d원\n", user.getTotalBenefit());
        }
        printNewLine();
    }

    public void printActualPaymentPrice(User user) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", user.getActualPaymentPrice());
        printNewLine();
    }

    public void printBadge(String badgeName) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeName);
    }

    public void printNewLine() {
        System.out.println();
    }
}
