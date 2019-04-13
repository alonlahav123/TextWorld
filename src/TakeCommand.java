public class TakeCommand implements Command {
    private Level level;
    private String itemName;
    private Player player;

    public TakeCommand(Level level, Player player) {
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
        Item item = player.getCurrentRoom().getItem(itemName);
        player.addItem(item);
        player.getCurrentRoom().removeItem(itemName);
    }

}
