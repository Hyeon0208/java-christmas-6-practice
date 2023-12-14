package christmas.domain.event;

import christmas.domain.user.User;
import java.util.List;

public class EventApplicator {
    private static final int MIN_EVENT_APPLICATION_CONDITIONS = 10000;
    private static final List<Event> events = java.util.List.of(
            new XmasEvent(),
            new WeekdayEvent(),
            new WeekendEvent(),
            new SpecialEvent(),
            new GiftEvent()
    );

    private EventApplicator() {
    }

    public static void apply(User user) {
        for (Event event : events) {
            if (isMeetConditionsForEvent(user) && event.isApplicable(user)) {
                user.applyEvent(createEventInfo(user, event));
            }
        }
    }

    private static boolean isMeetConditionsForEvent(User user) {
        return user.getTotalOrderPrice() >= MIN_EVENT_APPLICATION_CONDITIONS;
    }

    private static EventInfo createEventInfo(User user, Event event) {
        int discount = event.calculateDiscount(user);
        return new EventInfo(event.getName(), discount);
    }
}
