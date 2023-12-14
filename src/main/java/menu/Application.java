package menu;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printServiceStartMessage();
        System.out.println();

        List<String> coachNames = InputView.readCoachNames();
        OutputView.printCoachNames(coachNames);

        int coachNumber = coachNames.size();
        List<Coach> coaches = new ArrayList<>();
        for (int number = 0; number < coachNumber; number++) {
            List<String> impossibleMenus = InputView.readImpossibleMenus(coachNames.get(number));
            OutputView.printImpossibleMenus(impossibleMenus);
            System.out.println();
            coaches.add(new Coach(coachNames.get(number), impossibleMenus));
        }

        OutputView.printServiceResultMessage();
        OutputView.printResultMessage();

        for(int number = 0; number < coachNumber ; number++){
            MenuMaker menuMaker = new MenuMaker(coaches.get(number), List.of(1, 2, 3, 4, 5));
            System.out.println(coaches.get(number).getName() + menuMaker.makeFiveDayMenus());

        }

        System.out.println();
        OutputView.printEndMessage();
    }
}
