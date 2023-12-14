package view;

import utils.Parser;

import java.util.List;

public class OutputView {
    private static final String serviceStartMessage = "점심 메뉴 추천을 시작합니다.";
    private static final String serviceResultMessage = "메뉴 추천 결과입니다.";
    private static final String serviceEndMessage = "추천을 완료했습니다.";
    private static final String readCoachNameFormat = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final int d = 0;

    public static void printServiceStartMessage() {
        System.out.println(serviceStartMessage);
    }

    public static void printResultMessage() {
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

    public static void print() {
        System.out.println();
    }

}
