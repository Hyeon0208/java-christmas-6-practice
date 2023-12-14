package christmas.domain.user;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class VisitDate {
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private static final int XMAS_DAY = 25;
    private final LocalDate date;

    private VisitDate(LocalDate date) {
        this.date = date;
    }

    public static VisitDate from(int date) {
        LocalDate visitDate = LocalDate.of(2023, 12, date);
        return new VisitDate(visitDate);
    }

    public boolean isWeekday() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    public boolean isSpecialDay() {
        return SPECIAL_DAYS.contains(date.getDayOfMonth());
    }

    public boolean isXmasDay() {
        return date.getDayOfMonth() <= XMAS_DAY;
    }

    public int getVisitDate() {
        return date.getDayOfMonth();
    }
}
