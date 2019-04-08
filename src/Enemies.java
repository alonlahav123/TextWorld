public abstract class Enemies extends Creature{
    private Player player;


    public Enemies(Level.Room room, String name, String discription, Player player){
        super(room, name, discription);
        this.player = player;
    }

    public abstract void act();
}
