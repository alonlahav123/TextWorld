public class Entity {
    private Level.Room currentRoom;
    private String discription;
    private String name;

    public Entity(Level.Room currentRoom, String name) {
        this.currentRoom = currentRoom;
        this.name = name;
    }

    public Entity(Level.Room currentRoom, String name, String discription) {
        this.currentRoom = currentRoom;
        this.discription = discription;
        this.name = name;
    }


    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

}
