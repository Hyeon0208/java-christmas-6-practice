package christmas.domain.event;

import christmas.domain.User;

public interface Event {
    String getName();
    boolean isApplicable(User user);
    int calculateDiscount(User user);
}
