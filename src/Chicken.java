public class Chicken extends Enemies{

    public Chicken(Level.Room room, String name, String description, Player player) {
        super(room, name, description, player);
    }

    public Level.Room chooseNextRoom() {
        return getCurrentRoom().getRandomNeighbor();
    }

    public void act() {

    }
}
