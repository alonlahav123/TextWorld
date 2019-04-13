public class Popstar extends Enemies{

    public Popstar(Level.Room room, String name, String description, Player player) {
        super(room, name, description, player);
    }

    public Level.Room chooseNextRoom() {
        Level.Room nextRoom = getCurrentRoom().getRandomNeighbor();
        if(getCurrentRoom().equals(getPlayer().getCurrentRoom())) {
            return nextRoom;
        }

        for(int i = 0; i < getCurrentRoom().amountOfNeighbors(); i++) {
            Level.Room enemyNeighbor = getCurrentRoom().getNeighbors().get(i);

            if(enemyNeighbor.equals(getPlayer().getCurrentRoom())) {
                return enemyNeighbor;
            }
        }

        for(int i = 0; i < getCurrentRoom().amountOfNeighbors(); i++) {
            Level.Room enemyNeighbor = getCurrentRoom().getNeighbors().get(i);

            for(int j = 0; j < getPlayer().getCurrentRoom().amountOfNeighbors(); j++) {
                Level.Room playerNeighnor = getPlayer().getCurrentRoom().getNeighbors().get(j);

                if(enemyNeighbor.equals(playerNeighnor)) {
                    return enemyNeighbor;
                }
            }
        }

        return nextRoom;
    }

}
