package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuRecommender {

    public MenuRecommender() {

    }

    public static List<String> recommadateCategory(int code) {
        if (code == CategoryAndMenu.일식.getCode()) {
            return CategoryAndMenu.일식.getMenus();
        }
        if (code == CategoryAndMenu.한식.getCode()) {
            return CategoryAndMenu.한식.getMenus();
        }
        if (code == CategoryAndMenu.중식.getCode()) {
            return CategoryAndMenu.중식.getMenus();
        }
        if (code == CategoryAndMenu.아시안.getCode()) {
            return CategoryAndMenu.아시안.getMenus();
        }
        if (code == CategoryAndMenu.양식.getCode()) {
            return CategoryAndMenu.양식.getMenus();
        }
        return CategoryAndMenu.UNKNOWN.getMenus();
    }

    public static String selectMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
