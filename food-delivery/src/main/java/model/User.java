package model;

public class User {
    private String name;
    private String area;
    //other metadata can also be added


    public User(String name, String area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }
}
