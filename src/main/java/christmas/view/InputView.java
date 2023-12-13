package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.validator.VisitDateValidator;

public class InputView {

    public String inputVisitDate() {
        String visitDate = Console.readLine();
        VisitDateValidator.validate(visitDate);
        return visitDate;
    }
}
