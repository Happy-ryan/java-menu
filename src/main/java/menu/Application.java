package menu;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

        List<Integer> categoryCodes = CategoryMaker.makeCategoryCodes();
        OutputView.printResultCategory(categoryCodes);

        MenuMaker menuMaker = new MenuMaker(coaches, categoryCodes);
        for(int day = 0; day < 5 ; day++){
            menuMaker.makeOneDayCoachMenu(day);
        }
        LinkedHashMap<Coach, List<String>> fiveDayMenus = menuMaker.getFiveDayMenus();

        for(Coach coach : coaches){
            OutputView.printResultCoachMenu(coach.getName(),fiveDayMenus.get(coach));
        }

        System.out.println();
        OutputView.printEndMessage();
    }
}
