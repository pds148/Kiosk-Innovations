package menu;

import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuItem {

    private Map<String, List<Menu>> menus; //메뉴
    private Map<String, List<Product>> menuItemMap; // 상품메뉴
    private List<Product> cart;  //장바구니
    private double totalPrice;  //전체 가격
    private int orderNumber;   // 주문 번호

    public MenuItem() {
        menus = new HashMap<>();
        menuItemMap = new HashMap<>();
        cart = new ArrayList<>();
        totalPrice = 0.0;
        orderNumber = 0;
        initializeItems();
    }

    public void initializeItems() {
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거"));
        mainMenus.add(new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림"));
        mainMenus.add(new Menu("Drinks", "매장에서 직접 만드는 음료"));
        mainMenus.add(new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));

        List<Menu> orderMenu = new ArrayList<>();
        orderMenu.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        orderMenu.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));
        orderMenu.add(new Menu("Order List", "대기/완료된 주문목록을 조회합니다."));

        menus.put("Main", mainMenus);
        menus.put("Order", orderMenu);

        List<Product> burgerMenus = new ArrayList<>();
        burgerMenus.add(new Product("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenus.add(new Product("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenus.add(new Product("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        burgerMenus.add(new Product("Shack Stack", 12.4, "슈롬 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴"));
        burgerMenus.add(new Product("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenus.add(new Product("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<Product> frozenCustardMenu = new ArrayList<>();
        frozenCustardMenu.add(new Product("Shake of the Week", 6.5, "특별한 커스터드 플레이버"));
        frozenCustardMenu.add(new Product("Red Been Shake", 6.5, "Red Bean Shake"));
        frozenCustardMenu.add(new Product("Floats", 5.9, "신선한 커스터드와 함께 유유와 레드빈이 블렌딩 된 시즈널 쉐이크"));
        frozenCustardMenu.add(new Product("Cup & Cone", 4.9, "루트 비어, 퍼플 카우, 크림시클"));
        frozenCustardMenu.add(new Product("Concrete", 5.9, "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합"));

        List<Product> drinkMenu = new ArrayList<>();
        drinkMenu.add(new Product("Shack-made-Lemonade", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드(오리지날/시즈널)"));
        drinkMenu.add(new Product("Fresh Brewed Iced Tea", 3.4, "직접 유기농 홍차를 우려낸 아이스티"));
        drinkMenu.add(new Product("Fifty/Fifty", 3.5, "레몬에이드와 아이스티의 만남"));
        drinkMenu.add(new Product("Fountain Soba", 2.7, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프"));
        drinkMenu.add(new Product("Abita Root Beer", 4.4, "청량감 있는 독특한 미국식 무알콜 탄산음료"));
        drinkMenu.add(new Product("Bottled Water", 1.0, "지리산 암반대수층으로 만든 프리미엄 생수"));

        List<Product> beerMenu = new ArrayList<>();
        beerMenu.add(new Product("ShackMeister Ale", 9.8, "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주"));
        beerMenu.add(new Product("Magpie Brewing Co. Pale Ale", 6.8, "맥파이 브루잉 컴퍼니의 페일 에일 맥주"));

        menuItemMap.put("Burgers", burgerMenus);
        menuItemMap.put("Frozen Custard", frozenCustardMenu);
        menuItemMap.put("Drinks", drinkMenu);
        menuItemMap.put("Beer", beerMenu);
    }

    /*
     * 메뉴 조회
     * @param key 조회할 메뉴 키값
     * @return 조회된 메뉴 목록
     */
    public List<Menu> getMenus(String key) {
        List<Menu> menuList = new ArrayList<>();
        if (menus.containsKey(key)) {
            menuList.addAll(menus.get(key));
        }
        return menuList;
    }

    /*
     * 상품메뉴 조회
     * @param key 조회할 상품메뉴 키값
     * @return 조회된 상품메뉴 목록
     */
    public List<Product> getMenuItems(String key) {
        List<Product> productList = new ArrayList<>();
        if (menuItemMap.containsKey(key)) {
            productList.addAll(menuItemMap.get(key));
        }
        return productList;
    }

    public void addMenuItem(String menuName, Product newItem) {
        List<Product> menuItem = menuItemMap.get(menuName);
        if (menuItem != null) {
            menuItem.add(newItem);
            System.out.println("새로운 상품이 메뉴에 추가되었습니다.");
        } else {
            System.out.println("잘못된 메뉴명입니다.");
        }
    }


    public Map<String, List<Product>> getMenuItemMap() {
        return menuItemMap;
    }


    public List<Product> getCart() {
        return cart;
    }

    public void addMenu(String key, String description) {
        menus.get("Main").add(new Menu(key, description));
        menuItemMap.put(key, new ArrayList<>());
    }

    public String getMainMenuName(int id) {
        List<Menu> menuMenus = menus.get("Main");
        for (Menu menuMenu : menuMenus) {
            if (menuMenu.id == id) {
                return menuMenu.name;
            }
        }
        return "";
    }

    /*
    * 장바구니에 상품메뉴 추가
    * @param menuItems 장바구니에 추가할 상품메뉴
    */
    public void addToCart(Product menuItem) {
        cart.add(menuItem);
        totalPrice += menuItem.price;
    }

    /*
    * 장바구니 출력
    */
    public void displayAllProduct() {
        System.out.println("[ 전체 상품 목록 ]");
        menuItemMap.forEach((key, value) -> {
            System.out.println(" [ " + key + " Menu ] ");
            for (Product product : value) {
                System.out.println(product.id + ". " + product.name + "   | " + product.price + " | " + product.description);
            }
        });
    }

    public void displayCart() {
        for (Product product : cart) {
            System.out.println(product.name + "   | " + product.price + " | " + product.description);
        }
    }

    /*
    * 장바구니 전체가격 조회
    * @return 장바구니 전체가격
    */
    public double getTotalPrice() {
        return totalPrice;
    }

    /*
    * 신규 주문번호 조회
    * @return 신규 주문번호
    */
    public int generateOrderNumber() {
        orderNumber++;
        return orderNumber;
    }

    /*
    * 장바구니 초기화
    */
    public void resetCart() {
        cart.clear();
        totalPrice = 0.0;
    }


    public void displayAllItem() {
        System.out.println("[ 전체 상품 목록 ]");
        menuItemMap.forEach((key, value) -> {
            System.out.println(" [ " + key + " Menu ] ");
            for (Product product : value) {
                System.out.println(product.id + ". " + product.name + "   | " + product.price + " | " + product.description);
            }
        });
    }
}

