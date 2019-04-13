public class LookCommand implements Command{
    private Level level;
    private Player player;

    public LookCommand(Level level, Player player) {
        this.level = level;
        this.player = player;
    }

    public void init(String userString){
    }

    public void execute() {
        look(player.getCurrentRoom(), level);
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
