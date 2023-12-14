package menu;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainController {
    private static final int FIVE_DAYS = 5;

    public MainController() {

    }

    public void run() {
        serviceStart();

        List<String> coachNames = readAndPrintCoachNames();
        List<Coach> coaches = createCoaches(coachNames);

        printServiceAndResultMessages();

        List<Integer> categoryCodes = CategoryMaker.makeCategoryCodes();
        OutputView.printResultCategory(categoryCodes);

        MenuMaker menuMaker = new MenuMaker(coaches, categoryCodes);
        LinkedHashMap<Coach, List<String>> fiveDayMenus = makeFiveDayMenus(menuMaker);

        printFiveDayMenus(fiveDayMenus, coaches);

        serviceEnd();
    }

    private void serviceStart() {
        OutputView.printServiceStartMessage();
        System.out.println();
    }

    private List<String> readAndPrintCoachNames() {
        List<String> coachNames = InputView.readCoachNames();
        OutputView.printCoachNames(coachNames);
        return coachNames;
    }

    private List<Coach> createCoaches(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            List<String> impossibleMenus = readAndPrintImpossibleMenus(coachName);
            coaches.add(new Coach(coachName, impossibleMenus));
        }
        return coaches;
    }

    private List<String> readAndPrintImpossibleMenus(String coachName) {
        List<String> impossibleMenus = InputView.readImpossibleMenus(coachName);
        OutputView.printImpossibleMenus(impossibleMenus);
        System.out.println();
        return impossibleMenus;
    }

    private void printServiceAndResultMessages() {
        OutputView.printServiceResultMessage();
        OutputView.printResultMessage();
    }

    private LinkedHashMap<Coach, List<String>> makeFiveDayMenus(MenuMaker menuMaker) {
        for (int day = 0; day < FIVE_DAYS; day++) {
            menuMaker.makeOneDayCoachMenu(day);
        }
        LinkedHashMap<Coach, List<String>> fiveDayMenus = menuMaker.getFiveDayMenus();
        return fiveDayMenus;
    }

    private void printFiveDayMenus(LinkedHashMap<Coach, List<String>> fiveDayMenus, List<Coach> coaches) {
        for (Coach coach : coaches) {
            OutputView.printResultCoachMenu(coach.getName(), fiveDayMenus.get(coach));
        }
    }

    private void serviceEnd() {
        System.out.println();
        OutputView.printEndMessage();
    }
}

