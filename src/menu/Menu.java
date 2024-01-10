package menu;

public class Menu {

    static int objectIdGenerator = 1;
    public int id;
    public String name;
    public String description;

    public Menu(String name, String description) {
        this.id = objectIdGenerator;
        this.name = name;
        this.description = description;
    }

}
