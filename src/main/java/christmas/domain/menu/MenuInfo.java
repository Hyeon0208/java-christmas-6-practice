package christmas.domain.menu;

public class MenuInfo {
    private static final int MENU_NAME_INDEX = 0;
    private static final int MENU_PRICE_INDEX = 1;
    private final String name;
    private final int price;

    public MenuInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static MenuInfo from(Object[] menu) {
        String name = (String) menu[MENU_NAME_INDEX];
        int price = (int) menu[MENU_PRICE_INDEX];
        return new MenuInfo(name, price);
    }

    public boolean equalsName(String menuName) {
        return name.equals(menuName);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
