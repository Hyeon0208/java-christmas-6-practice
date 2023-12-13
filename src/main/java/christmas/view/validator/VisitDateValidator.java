package christmas.view.validator;

import christmas.util.StringConvertor;
import christmas.view.ErrorView;

public class VisitDateValidator {
    private static final int MIN_VISIT_DATE_RANGE = 1;
    private static final int MAX_VISIT_DATE_RANGE = 31;

    private VisitDateValidator() {
    }

    public static void validate(String input) {
        validateIsNumber(input);
        validateBlank(input);
        validateRange(input);
    }

    private static void validateIsNumber(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throwError();
        }
    }

    private static void validateRange(String input) {
        int visitDate = StringConvertor.convertToInt(input);
        if (visitDate < MIN_VISIT_DATE_RANGE || visitDate > MAX_VISIT_DATE_RANGE) {
            throwError();
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throwError();
        }
    }

    private static void throwError() {
        throw new IllegalArgumentException(ErrorView.DATE_INPUT_ERROR);
    }
}
