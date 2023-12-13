package christmas.domain.event;

import christmas.domain.User;
import java.util.EnumSet;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    private final String name;
    private final int condition;

    Badge(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public static String getBadgeBasedOnConditions(User user) {
        return EnumSet.allOf(Badge.class).stream()
                .filter(badge -> badge.condition <= user.getTotalBenefit())
                .map(Badge::getName)
                .findFirst()
                .orElse("없음");
    }

    public String getName() {
        return name;
    }
}
