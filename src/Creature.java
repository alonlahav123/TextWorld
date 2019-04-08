import java.sql.SQLOutput;

public class Creature extends Entity {
    private Level.Room currentRoom;

    public Creature(Level.Room room, String name, String discription) {
        super(name, discription);
        currentRoom = room;
    }

    public void moveToRoom(Level.Room newRoom) {

        if(currentRoom.hasNeighbor(newRoom)) {
            currentRoom = newRoom;
        } else {
            System.out.println("You can't go there");
        }
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
