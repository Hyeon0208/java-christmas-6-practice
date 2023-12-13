package christmas.domain;

import christmas.domain.event.EventInfo;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int GIFT_CONDITION = 120000;
    private final Orders orders;
    private final VisitDate visitDate;
    private final List<EventInfo> eventInfos;

    public User(Orders orders, VisitDate visitDate) {
        this.orders = orders;
        this.visitDate = visitDate;
        this.eventInfos = new ArrayList<>();
    }

    public boolean isReceiveGift() {
        return orders.getTotalOrderPrice() >= GIFT_CONDITION;
    }

    public List<OrderInfo> getOrders() {
        return orders.getOrders();
    }

    public int getTotalOrderPrice() {
        return orders.getTotalOrderPrice();
    }

    public int getVisitDate() {
        return visitDate.getVisitDate();
    }

    public List<EventInfo> getAppliedEventInfos() {
        return eventInfos;
    }

    public boolean isVisitWeekday() {
        return visitDate.isWeekday();
    }

    public boolean isVisitSpecialDay() {
        return visitDate.isSpecialDay();
    }

    public boolean isVisitXmasDay() {
        return visitDate.isXmasDay();
    }

    public boolean notAppliedEvent() {
        return eventInfos.isEmpty();
    }

    public void applyEvent(EventInfo eventInfo) {
        eventInfos.add(eventInfo);
    }
}
