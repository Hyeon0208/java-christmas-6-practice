package christmas.domain.event;

import christmas.domain.User;

public class SpecialEvent implements Event {
    private final String name = "특별 할인";
    private final int discount = 1000;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isApplicable(User user) {
        return user.isVisitSpecialDay();
    }

    @Override
    public int calculateDiscount(User user) {
        return discount;
    }
}
