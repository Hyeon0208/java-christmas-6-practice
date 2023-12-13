package christmas.domain.event;

public record EventInfo(String name, int discount) {
    private static final String EXCLUDED_FROM_TOTAL_BENEFIT = "증정 이벤트";

    public boolean isGiftEvent() {
        return name.equals(EXCLUDED_FROM_TOTAL_BENEFIT);
    }
}
