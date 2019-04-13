public class DropCommand implements Command {
    private Level level;
    private String itemName;
    private Player player;

    public DropCommand(Level level, Player player) {
        this.level = level;
        this.player = player;
    }

    public void init(String userString){
        this.itemName = getLastWordIn( userString );
    }

    private String getLastWordIn(String userString) {
        String[] responseSplit = userString.split(" ");

        return responseSplit[responseSplit.length-1];
    }

    public void execute() {
        Item item = player.getItem(itemName);
        player.dropItem(item);
        player.getCurrentRoom().addItem(item.getName(), item.getDescription());
    }

}
