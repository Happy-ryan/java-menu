package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputView {
    public static List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        while (true) {
            try {
                List<String> stringList = inputCoachNames();
                return stringList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<String> inputCoachNames() {
        List<String> stringList = List.of(Console.readLine().split(","));
        validateCoachNames(stringList);
        return stringList;
    }

    private static void validateCoachNames(List<String> stringList) {
        Set<String> uniqueNames = new HashSet<>();

        for (String string : stringList) {
            if (string.length() < 2 || 4 < string.length()) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 ~ 4글자입니다.");
            }
            if (!string.matches("^[가-힣]+$")) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 한글만 가능합니다.");
            }
            if (!uniqueNames.add(string)) {
                throw new IllegalArgumentException("[ERROR] 중복된 코치이름이 존재합니다.");
            }
        }
        if (uniqueNames.size() < 2 || 5 < uniqueNames.size()) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }
    }

    // === //
    public static List<String> readImpossibleMenus(String name) {
        OutputView.printCoachNaemForamt(name);
        while (true) {
            try {
                List<String> stringList = inputImpossibleMenus();
                return stringList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<String> inputImpossibleMenus() {
        List<String> stringList = List.of(Console.readLine().split(","));
        validateImpossibleMenus(stringList);
        return stringList;
    }

    private static void validateImpossibleMenus(List<String> stringList) {
        Set<String> uniqueNames = new HashSet<>();

        for (String string : stringList) {
            if (!string.matches("^[가-힣\\s]+$")) {
                throw new IllegalArgumentException("[ERROR] 한글 또는 공백만 허용합니다.");
            }
            if (!uniqueNames.add(string)) {
                throw new IllegalArgumentException("[ERROR] 중복된 메뉴 존재합니다.");
            }
        }
        if (uniqueNames.size() < 0 || 2 < uniqueNames.size()) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 최소 0개, 최대 2개입니다.");
        }
    }
}
