package christmas.domain.event;

import christmas.domain.MenuBoard;
import christmas.domain.User;

public class WeekdayEvent implements Event {
    private final String name = "평일 할인";
    private final int discount = 2023;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isApplicable(User user) {
        return user.isVisitWeekday();
    }

    @Override
    public int calculateDiscount(User user) {
        int dessertCount = user.getOrders().stream()
                .filter(orderInfo -> MenuBoard.isDessertCategory(orderInfo.getName()))
                .mapToInt(orderInfo -> orderInfo.getCount())
                .sum();
        return dessertCount * discount;
    }
}
