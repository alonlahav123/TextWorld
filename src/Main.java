
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Level l = new Level();
        l.setup();
        Player player = new Player(l.getRandomRoom(),"me", "big boi", l);
        l.addCreatures(player);

        String response = "";
        Scanner s = new Scanner(System.in);

        do{
            System.out.println("You are in the " + player.getCurrentRoom());
            System.out.print("What do you want to do? > ");
            response = s.nextLine();

            act(response, player, l);

        } while(!response.equals("quit"));

    }

    private static void act(String response, Player player, Level l) {
        String[] responseSplit = response.split(" ");

        if(responseSplit[0].equals("go")) {
            player.moveToRoom( l.getRoom(responseSplit[1]) );
            l.updateEnemies();
        } else if(response.equals("look")) {
            look(player.getCurrentRoom(), l);
        } else if(responseSplit[0].equals("add")) {
            l.addDirectedEdge(player.getCurrentRoom().getName(), responseSplit[1]);
        } else if(response.equals("quit")) {
            // exit loop
        } else if(responseSplit[0].equals("pick") && responseSplit[1].equals("up")) {
            Item item = player.getCurrentRoom().getItem(responseSplit[2]);
            player.addItem(item);
            player.getCurrentRoom().removeItem(responseSplit[2]);
        } else if(responseSplit[0].equals("drop")) {
            Item item = player.getItem(responseSplit[1]);
            player.dropItem(item);
            player.getCurrentRoom().addItem(item.getName(), item.getDescription());
        } else {
            System.out.println("Commands: \"go <roomname>\", \"look\", add \"<roomname>\", and \"quit\"");
        }
    }

    private static void look(Level.Room current, Level level) {

        if(current.amountOfNeighbors() == 0) {
            System.out.println("There are no neighbors!");
        } else {
            System.out.print("Neighboring Rooms: ");
            System.out.println(current.getNeighborNames());
        }

        System.out.print("Items: ");
        System.out.println(current.getItems());

        System.out.println("Creatures in the room: " + level.getNearEnemies(current));
    }

}
