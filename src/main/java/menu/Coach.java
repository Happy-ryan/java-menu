package menu;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> impossibleMenus;

    public Coach(String name, List<String> impossibleMenus) {
        this.name = name;
        this.impossibleMenus = impossibleMenus;
    }

    public String getName() {
        return name;
    }

    public List<String> getImpossibleMenus() {
        return impossibleMenus;
    }
}
