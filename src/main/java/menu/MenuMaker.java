package menu;

import java.util.ArrayList;
import java.util.List;

//  특정 코치의 5일 메뉴 추천(못 먹는 음식, 중복 음식 불가능)
public class MenuMaker {
    private Coach coach;
    // 같은 카테고리 3회이상 나오지 않도록 만들어짐!
    private final List<Integer> categoryCodes;

    public MenuMaker(Coach coach, List<Integer> categoryCodes) {
        this.coach = coach;
        this.categoryCodes = categoryCodes;
    }

    public List<String> makeFiveDayMenus() {
        List<String> fiveDayMenus = new ArrayList<>();
        for (int day = 0; day < categoryCodes.size(); day++) {
            List<String> menus = MenuRecommender.recommadateCategory(categoryCodes.get(day));

            String oneDayMenu = makeOneDayMenu(menus, fiveDayMenus);

            fiveDayMenus.add(oneDayMenu);
        }
        return fiveDayMenus;
    }

    public String makeOneDayMenu(List<String> menus, List<String> fiveDayMenus) {
        while (true) {
            String menu = MenuRecommender.selectMenu(menus);
            if (!fiveDayMenus.contains(menu) && !coach.getImpossibleMenus().contains(menu)) {
                return menu;
            }
        }
    }
}
