package utils;

import java.util.*;

public class Parser {
    // 김성한,김성한,김성한 -> OutputView에 도움
    public static String joinWithoutBlank(List<String> stringList) {
        return String.join(",", stringList);
    }

    // 김성한, 김성한, 김성한 -> OutputView에 도움
    public static String joinWithBlank(List<String> stringList) {
        return String.join(", ", stringList);
    }

    // List<String> -> List<Integer> 로 변경 -> inputView에 도움
    public static List<Integer> parseInteger(List<String> stringList) {
        List<Integer> IntegerList = new ArrayList<>();
        for (String string : stringList) {
            IntegerList.add(Integer.parseInt(string));
        }
        return IntegerList;
    }
}
