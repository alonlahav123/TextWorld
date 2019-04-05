import java.sql.SQLOutput;

public abstract class Creature extends Entity {

    public Creature(Level.Room room, String name) {
        super(room, name);
    }

    public Creature(Level.Room room, String name, String discription) {
        super(room, name, discription);
    }

    public void moveToRoom(Level.Room newRoom) {
        Level.Room currentRoom = getCurrentRoom();

        if(currentRoom.hasNeighbor(newRoom)) {
            setCurrentRoom(newRoom);
        } else {
            System.out.println("You can't go there");
        }
    }

    public abstract void act();
}
