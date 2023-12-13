package christmas.domain;

import christmas.constant.Separator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private final List<OrderInfo> orders;

    public Orders(List<OrderInfo> orders) {
        this.orders = orders;
    }

    public static Orders from(String orderMenus) {
        List<OrderInfo> orders = Arrays.stream(Separator.COMMA.split(orderMenus))
                .map(Separator.HYPHEN::split)
                .map(OrderInfo::from)
                .collect(Collectors.toList());
        return new Orders(orders);
    }

    public int getTotalOrderPrice() {
        int totalOrderPrice = 0;
        for (OrderInfo order : orders) {
            int menuPrice = MenuBoard.getMenuPrice(order.getName());
            totalOrderPrice += (menuPrice * order.getCount());
        }
        return totalOrderPrice;
    }

    public List<OrderInfo> getOrders() {
        return orders;
    }
}
