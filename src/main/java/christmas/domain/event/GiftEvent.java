package christmas.domain.event;

import christmas.domain.User;

public class GiftEvent implements Event {
    private final String name = "증정 이벤트";
    private final int discount = 25000;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isApplicable(User user) {
        return user.isReceiveGift();
    }

    @Override
    public int calculateDiscount(User user) {
        return discount;
    }
}
