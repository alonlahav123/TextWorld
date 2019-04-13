public class Wumpus extends Enemies{

    public Wumpus(Level.Room room, String name, String description, Player player) {
        super(room, name, description, player);
    }

    public Level.Room chooseNextRoom() {
        Level.Room nextRoom = getCurrentRoom().getRandomNeighbor();

        for(int i = 0; i < getCurrentRoom().amountOfNeighbors(); i++) {
            Level.Room enemyNeighbor = getCurrentRoom().getNeighbors().get(i);
            for(int j = 0; j < getPlayer().getCurrentRoom().amountOfNeighbors(); j++) {
                Level.Room playerNeighbor = getPlayer().getCurrentRoom().getNeighbors().get(j);

                if(!enemyNeighbor.equals(playerNeighbor)) {
                    return enemyNeighbor;
                }
            }
        }

        int count = 0;
        while(nextRoom==getPlayer().getCurrentRoom()) {
            nextRoom = getCurrentRoom().getRandomNeighbor();
            count++;
            if(count == 5) {
                return nextRoom;
            }
        }
        return nextRoom;
    }

}
