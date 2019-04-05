
import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    //private List<Room> rooms;
    private HashMap<String, Room> rooms;

    public Level() {
        rooms = new HashMap<String, Room>();
    }

    public void addRoom(String name, String description) {
        Room n = new Room(name, description);
        rooms.put(name, n);
    }


    public void addDirectedEdge(String n1, String n2) {
        Room node1 = getRoom(n1);
        Room node2 = getRoom(n2);
        node1.addNeighbor(node2);
    }

    public void addUndirectedEdge(String n1, String n2) {
        addDirectedEdge(n1, n2);
        addDirectedEdge(n2, n1);
    }

    public Room getRoom(String name){

        if(rooms.containsKey(name)) {
            return rooms.get(name);
        }

        return null;
    }

    public class Room {
        private String name;
        private ArrayList<Room> neighbors;
        private String description;

        public Room(String name, String description) {
            neighbors = new ArrayList<>();
            this.name = name;
            this.description = description;
        }

        public void addNeighbor(Room n){
            neighbors.add(n);
        }

        public Room getNeighbor(String name){

            for(Room n : neighbors) {
                if(n.getName().equals(name)) {
                    return n;
                }
            }

            return null;
        }

        public String getName() {
            return name;
        }

        public String getNeighborNames() {
            String names = "";
            for(Room n : neighbors) {
                names += n.getName() + " ";
            }

            return names;
        }

        public int amountOfNeighbors() {
            return neighbors.size();
        }
    }
}
