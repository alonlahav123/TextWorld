
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static HashMap<String, Command> commands;

    public static void main(String[] args){

        Level l = new Level();
        l.setup();
        Player player = new Player(l.getRandomRoom(),"me", "big boi", l);
        l.addCreatures(player);

        String response = "";
        Scanner s = new Scanner(System.in);

        setupCommands(l, player);

        do{
            System.out.println("You are in the " + player.getCurrentRoom());
            System.out.print("What do you want to do? > ");
            response = s.nextLine();
            Command command = lookupCommand(response);
            command.execute();
            //act(response, player, l);

        } while(!response.equals("quit"));

    }

    private static void setupCommands(Level level, Player player) {
        commands = new HashMap<>();

        commands.put("take", new TakeCommand(level, player));
        commands.put("drop", new DropCommand(level, player));
        commands.put("look", new LookCommand(level, player));
        commands.put("go", new GoCommand(level, player));
    }

    private static Command lookupCommand(String response) {
        String commandWord = getFirstWordIn( response );

        Command c = commands.get(commandWord);
        if(c == null) {
            return new EmptyCommand();
        }

        c.init(response);

        return c;
    }

    private static String getFirstWordIn(String response) {
        String[] responseSplit = response.split(" ");

        return responseSplit[0];
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
        } else if(responseSplit[0].equals("take")) {
            Item item = player.getCurrentRoom().getItem(responseSplit[1]);
            player.addItem(item);
            player.getCurrentRoom().removeItem(responseSplit[1]);
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
