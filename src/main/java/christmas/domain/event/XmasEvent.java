package christmas.domain.event;

import christmas.domain.user.User;

public class XmasEvent implements Event {
    private final String name = "크리스마스 디데이 할인";
    private final int discountPrice = 1000;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isApplicable(User user) {
        return user.isVisitXmasDay();
    }

    @Override
    public int calculateDiscount(User user) {
        return discountPrice + ((user.getVisitDate() - 1) * 100);
    }
}
