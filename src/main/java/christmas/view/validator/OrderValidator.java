package christmas.view.validator;

import christmas.constant.Separator;
import christmas.domain.menu.MenuBoard;
import christmas.util.StringConvertor;
import christmas.view.ErrorView;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderValidator {
    private static final int MIN_ORDER_COUNT = 1;
    private static final int MAX_ORDER_LIMIT = 20;

    private OrderValidator() {
    }

    public static void validate(String input) {
        validateOrderFormat(input);
        String[] orders = Separator.COMMA.split(input);
        validateOrderMenuFormat(orders);
        validateExistMenu(orders);
        validateDuplication(orders);
        validateIsOnlyDrink(orders);
        validateTotalOrderCount(orders);
        validateOrderMenuCount(orders);
    }

    private static void validateOrderFormat(String input) {
        if (!input.contains(Separator.COMMA.getSeparator())) {
            throwError();
        }
    }

    private static void validateOrderMenuFormat(String[] orders) {
        for (String order : orders) {
            if (!order.contains(Separator.HYPHEN.getSeparator())) {
                throwError();
            }
        }
    }

    private static void validateExistMenu(String[] orders) {
        for (String order : orders) {
            String[] orderInfo = Separator.HYPHEN.split(order);
            if (!MenuBoard.isExist(orderInfo[0])) {
                throwError();
            }
        }
    }

    private static void validateIsOnlyDrink(String[] orders) {
        if (orders.length == 1) {
            String[] orderInfo = Separator.HYPHEN.split(orders[0]);
            if (!MenuBoard.isDrinkCategory(orderInfo[0])) {
                throwError();
            }
        }
    }

    private static void validateOrderMenuCount(String[] orders) {
        for (String order : orders) {
            String[] orderInfo = Separator.HYPHEN.split(order);
            String count = orderInfo[1];
            validateOrderCountMinCondition(count);
            validateOrderCountIsNumber(count);
        }
    }

    private static void validateDuplication(String[] orders) {
        Set<String> deDuplicatedNames = Arrays.stream(orders)
                .map(Separator.HYPHEN::split)
                .map(order -> order[0])
                .collect(Collectors.toSet());
        if (deDuplicatedNames.size() != orders.length) {
            throwError();
        }
    }

    private static void validateTotalOrderCount(String[] orders) {
        int totalOrderCount = Arrays.stream(orders)
                .map(Separator.HYPHEN::split)
                .map(order -> order[1])
                .mapToInt(Integer::parseInt)
                .sum();
        if (totalOrderCount > MAX_ORDER_LIMIT) {
            throwError();
        }
    }

    private static void validateOrderCountMinCondition(String count) {
        if (StringConvertor.convertToInt(count) < MIN_ORDER_COUNT) {
            throwError();
        }
    }

    private static void validateOrderCountIsNumber(String count) {
        if (!RegexPattern.ONLY_NUMBER.matches(count)) {
            throwError();
        }
    }

    private static void throwError() {
        throw new IllegalArgumentException(ErrorView.ORDER_INPUT_ERROR);
    }
}
