package christmas.view;

import christmas.domain.OrderInfo;
import christmas.domain.Orders;

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
        System.out.println();
    }

    public void printOrdersHistory(Orders orders) {
        StringBuilder orderHistory = new StringBuilder();
        orderHistory.append("<주문 메뉴>").append("\n");
        for (OrderInfo order : orders.getOrders()) {
            orderHistory.append(String.format("%s %d개\n", order.getName(), order.getCount()));
        }
        System.out.println(orderHistory);
    }
}
