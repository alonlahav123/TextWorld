
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Level g = new Level();
        g.addRoom("hall", "a long dark hallway");
        g.addRoom("closet", "a dark, dark closet");
        g.addRoom("dungeon", "very scary house");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        Level.Room current = g.getRoom("hall");

        String response = "";
        Scanner s = new Scanner(System.in);

        do{
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
        } while(!response.equals("quit"));

    }

    private static void look(Level.Room current) {

        if(current.amountOfNeighbors() == 0) {
            System.out.println("There are no neighbors!");
        } else {
            for(int i = 0; i < current.amountOfNeighbors(); i++) {
                System.out.println(current.getNeighborNames());
            }
        }
    }

}
