import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Creature{
    private Level level;
    private ArrayList<Item> items;

    public Player(Level.Room currentRoom, String name, String description, Level level) {
        super(currentRoom,name,description);
        this.level = level;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " has been added to your inventory");
    }

    public void dropItem(Item item) {
        items.remove(item);
        System.out.println(item.getName() + " has been dropped from your inventory");
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItem(String name) {
        for(int i = 0; i < items.size(); i++) {
            if(name.equals(items.get(i).getName())) {
                return items.get(i);
            }
        }

        return null;
    }

    private static void look(Level.Room current) {

        if(current.amountOfNeighbors() == 0) {
            System.out.println("There are no neighbors!");
        } else {
            System.out.println(current.getNeighborNames());
        }
    }
}

