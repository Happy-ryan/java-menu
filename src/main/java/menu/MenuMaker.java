package menu;

import java.util.*;

//  특정 코치의 5일 메뉴 추천(못 먹는 음식, 중복 음식 불가능)
public class MenuMaker {
    private final List<Coach> coachs;
    // 같은 카테고리 3회이상 나오지 않도록 만들어짐!
    private final List<Integer> categoryCodes;

    private LinkedHashMap<Coach, List<String>> fiveDayMenus = new LinkedHashMap<>();

    public MenuMaker(List<Coach> coachs, List<Integer> categoryCodes) {
        this.coachs = coachs;
        this.categoryCodes = categoryCodes;
    }

    // 현재: 한 코치의 5일치 식단을 한 번에 처리
    // 테스트코드 : 월 / 화 ..각각 들어 그래서 테스트코드에서 문제 발생!!
    // 월 코드 2개 > 각 코치들에게 각각 들어감...그래서 각 요일마다 각 코치를 처리해여함.
    public List<String> makeOneDayCoachMenu(int day) {
        for (int number = 0; number < coachs.size(); number++) {

            Coach coach = coachs.get(number);

            List<String> menus = MenuRecommender.recommadateCategory(categoryCodes.get(day));

            if (!fiveDayMenus.containsKey(coach)) {
                fiveDayMenus.put(coach, new ArrayList<>());
            }
            String oneDayMenu = makeOneDayMenu(menus, coach);
            fiveDayMenus.get(coach).add(oneDayMenu);
        }
        return List.of();
    }

    public String makeOneDayMenu(List<String> menus, Coach coach) {
        while (true) {
            String menu = MenuRecommender.selectMenu(menus);
            if (!coach.getImpossibleMenus().contains(menu) && !fiveDayMenus.get(coach).contains(menu)) {
                return menu;
            }
        }
    }
    public LinkedHashMap<Coach, List<String>> getFiveDayMenus() {
        return fiveDayMenus;
    }
}
