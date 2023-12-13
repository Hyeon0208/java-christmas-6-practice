package christmas.domain.user;

import christmas.util.StringConvertor;

public class OrderInfo {
    private static final int ORDER_MENU_NAME_INDEX = 0;
    private static final int ORDER_MENU_COUNT_INDEX = 1;
    private final String name;
    private final int count;

    private OrderInfo(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public static OrderInfo from(String[] order) {
        String name = order[ORDER_MENU_NAME_INDEX];
        int price = StringConvertor.convertToInt(order[ORDER_MENU_COUNT_INDEX]);
        return new OrderInfo(name, price);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
