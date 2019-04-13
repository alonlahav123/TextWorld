public class GoCommand implements Command{
    private Level level;
    private Player player;
    private String roomName;

    public GoCommand(Level level, Player player) {
        this.level = level;
        this.player = player;
    }

    public void init(String userString){
        this.roomName = getLastWordIn( userString );
    }

    private String getLastWordIn(String userString) {
        String[] responseSplit = userString.split(" ");
        return responseSplit[responseSplit.length-1];
    }

    public void execute() {
        player.moveToRoom( level.getRoom(roomName) );
        level.updateEnemies();
    }
}
