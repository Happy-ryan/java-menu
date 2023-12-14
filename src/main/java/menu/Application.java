package menu;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printServiceStartMessage();
        System.out.println();

        List<String> coachNames = InputView.readCoachNames();
        System.out.println(coachNames);

        int coachNumber = coachNames.size();
        for (int number = 0; number < coachNumber; number++) {
            List<String> impossibleMenus = InputView.readImpossibleMenus(coachNames.get(number));
            System.out.println(impossibleMenus);
        }
        OutputView.printResultMessage();
        OutputView.printEndMessage();
    }
}
