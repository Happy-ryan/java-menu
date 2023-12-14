package view;

import menu.CategoryAndMenu;
import utils.Parser;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String serviceStartMessage = "점심 메뉴 추천을 시작합니다.";
    private static final String serviceResultMessage = "메뉴 추천 결과입니다.";
    private static final String serviceEndMessage = "추천을 완료했습니다.";
    private static final String readCoachNameFormat = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String resultMessage = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String resultFormat = "[ %s ]";

    private static final int d = 0;

    public static void printServiceStartMessage() {
        System.out.println(serviceStartMessage);
    }

    public static void printServiceResultMessage() {
        System.out.println(serviceResultMessage);
    }

    public static void printEndMessage() {
        System.out.println(serviceEndMessage);
    }

    public static void printCoachNaemForamt(String name) {
        System.out.println(String.format(readCoachNameFormat, name));
    }

    public static void printCoachNames(List<String> coachNames) {
        System.out.println(Parser.joinWithoutBlank(coachNames));
    }

    public static void printImpossibleMenus(List<String> impossibleMenus) {
        System.out.println(Parser.joinWithoutBlank(impossibleMenus));
    }

    public static void printResultMessage() {
        System.out.println(resultMessage);
    }

    public static void printResultCategory(List<Integer> categoryCodes) {
        List<String> categoryNames = new ArrayList<>();
        categoryNames.add("카테고리");
        for(int day = 0; day < 5; day++){
            categoryNames.add(CategoryAndMenu.getCategory(categoryCodes.get(day)));
        }
        System.out.println(String.format(resultFormat, Parser.joinWithBlank(categoryNames)));
    }

    public static void printResultCoachMenu(String name, List<String> menus) {
        menus.add(0, name);
        System.out.println(String.format(resultFormat, Parser.joinWithBlank(menus)));
    }
}
