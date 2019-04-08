public abstract class Enemies extends Creature{
    private Player player;

    public Enemies(Level.Room room, String name, String discription, Player player){
        super(room, name, discription);
        this.player = player;
    }

    public void move() {
        Level.Room room = chooseNextRoom();

        if(room != null) {
            moveToRoom(room);
        }
    }

    protected abstract Level.Room chooseNextRoom();

    public abstract void act();
}
