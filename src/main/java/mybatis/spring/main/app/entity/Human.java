package mybatis.spring.main.app.entity;

public class Human {
    private int id;
    private String name;
    private String height;

    public Human() {
    }

    public Human(int id, String name, String height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
