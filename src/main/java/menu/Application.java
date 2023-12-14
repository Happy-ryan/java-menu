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
            coaches.add(new Coach(coachNames.get(number), impossibleMenus));
        }

        MenuRecommender menuMaker = new MenuRecommender();
        System.out.println(menuMaker.selectMenu(menuMaker.recommadateCategory(1)));
        System.out.println(menuMaker.selectMenu(menuMaker.recommadateCategory(1)));

        OutputView.printResultMessage();
        OutputView.printEndMessage();
    }
}
