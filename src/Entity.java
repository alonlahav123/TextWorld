public class Entity {
    private String description;
    private String name;

    public Entity(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
