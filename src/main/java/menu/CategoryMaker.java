package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class CategoryMaker {
    private static final int FIVE_DAYS = 5;
    private static final int MAX_POSSIBLE_CATEGORY = 2;
    private static final int CATEGORY_CODE_START = 1;
    private static final int CATEGORY_CODE_END = 5;

    public static List<Integer> makeCategoryCodes() {
        List<Integer> categoryCodes = new ArrayList<>(FIVE_DAYS);
        Map<Integer, Integer> countMap = initializeCountMap();

        for (int day = 0; day < FIVE_DAYS; day++) {
            addCategoryCode(categoryCodes, countMap);
        }

        return categoryCodes;
    }

    private static Map<Integer, Integer> initializeCountMap() {
        Map<Integer, Integer> categoryNumber = new HashMap<>();
        for (int code = 1; code <= FIVE_DAYS; code++) {
            categoryNumber.put(code, 0);
        }
        return categoryNumber;
    }

    private static void addCategoryCode(List<Integer> categoryCodes, Map<Integer, Integer> countMap) {
        while (true) {
            int categoryCode = Randoms.pickNumberInRange(CATEGORY_CODE_START, CATEGORY_CODE_END);
            if (countMap.get(categoryCode) < MAX_POSSIBLE_CATEGORY) {
                categoryCodes.add(categoryCode);
                countMap.put(categoryCode, countMap.get(categoryCode) + 1);
                break;
            }
        }
    }
}
