import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Creature{
    private String name, description;
    private ArrayList<Item> items;
    private Level.Room currentRoom;

    public Player(Level.Room currentRoom, String name, String description) {
        super(currentRoom,name,description);
    }

    public void addItem(Item item) {

    }

    @Override
    public void act() {
        String response = "";
        Scanner s = new Scanner(System.in);

        System.out.println("You are in the " + current.getName());
        System.out.print("What do you want to do? > ");
        response = s.nextLine();
        String[] responseSplit = response.split(" ");

        if(responseSplit[0].equals("go")) {
            current = g.getRoom(responseSplit[1]);
        } else if(response.equals("look")) {
            look(current);
        } else if(responseSplit[0].equals("add")) {
            g.addDirectedEdge(current.getName(), responseSplit[1]);
        } else if(response.equals("quit")) {

        } else {
            System.out.println("Commands: \"go <roomname>\", \"look\", add \"<roomname>\"");
        }
    }
}

