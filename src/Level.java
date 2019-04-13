import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private HashMap<String, Room> rooms;
    private ArrayList<Item> items;
    private ArrayList<Enemies> enemies;

    public Level() {
        rooms = new HashMap<>();
        this.items = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    public void setup() {
        addRoom("hall", "a long dark hallway");
        addRoom("closet", "a dark, dark closet");
        addRoom("dungeon", "very scary house");
        addRoom("restroom", "stinky place");
        addRoom("cell", "you can go in but not out");
        addRoom("bedroom", "where the king sleeps");
        addRoom( "courtyard", "patio area with a nice fountain");
        addRoom("roof", "has a nice view of the kingdom");
        addRoom("kitchen", "where the meals are made");


        addUndirectedEdge("kitchen", "dungeon");
        addUndirectedEdge("kitchen", "bedroom");
        addDirectedEdge("kitchen", "hall");
        addDirectedEdge("hall", "dungeon");
        addUndirectedEdge("hall", "closet");
        addUndirectedEdge("courtyard", "bedroom");
        addDirectedEdge("courtyard", "roof");
        addDirectedEdge("roof", "bedroom");
        addUndirectedEdge("bedroom", "restroom");
        addUndirectedEdge("dungeon", "restroom");
        addDirectedEdge("restroom", "cell");
        addDirectedEdge("restroom", "hall");

        for(int i = 0; i < 7; i++) {
            addItem("food" +i, "edible thingy", getRandomRoom());
        }
    }

    public String getNearEnemies(Level.Room room) {
        String output = "";

        for(int i = 0; i < enemies.size(); i++) {
            if(enemies.get(i).getCurrentRoom().equals(room)) {
                output += enemies.get(i).getName() + " ";
            }
        }

        return output;
    }

    public void updateEnemies() {
        for(int i = 0; i < enemies.size(); i++) {
            enemies.get(i).move();
        }
    }

    public void addCreatures(Player player) {
        int Chickens = 2;
        int Popstars = 2;
        int Wumpi = 3;

        for(int i = 0; i < Chickens; i++) {
            Chicken chik = new Chicken(getRandomRoom(), "Chicken" + i, "hungry boi", player);
            enemies.add(chik);
        }

        for(int i = 0; i < Popstars; i++) {
            Popstar popstar = new Popstar(getRandomRoom(), "Popstar" + i, "sneaky boi", player);
            enemies.add(popstar);
        }

        for(int i = 0; i < Wumpi; i++) {
            Wumpus Wumpus = new Wumpus(getRandomRoom(), "Wumpus" + i, "scardy boi", player);
            enemies.add(Wumpus);
        }
    }

    public ArrayList<Enemies> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemies> enemies) {
        this.enemies = enemies;
    }

    public Level.Room getRandomRoom() {
        int i = (int)(Math.random()*rooms.keySet().size());
        int f = 0;

        for(String room : rooms.keySet()) {
            if(f == i) {
                return rooms.get(room);
            }
            f++;
        }

        System.out.println("There are no rooms");
        return null;
    }

    public void addRoom(String name, String description) {
        Room n = new Room(name, description);
        rooms.put(name, n);
    }

    public void addItem(String itemName, String description, String roomName) {
        rooms.get(roomName).addItem(itemName,description);
    }

    public void addItem(String itemName, String description, Room room) {
        room.addItem(itemName,description);
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
        private ArrayList<Item> items;

        public Room(String name, String description) {
            neighbors = new ArrayList<>();
            this.name = name;
            this.description = description;
            items = new ArrayList<>();
        }

        public void addNeighbor(Room n){
            neighbors.add(n);
        }

        public void addItem(String name, String description) {
            Item item = new Item(name, description);
            items.add(item);
        }

        public Item getItem(String name) {
            for(int i = 0; i < items.size(); i++) {
                if(name.equals(items.get(i).getName())) {
                    return items.get(i);
                }
            }

            return null;
        }

        public void removeItem(String name) {

            for(int i = 0; i < items.size(); i++) {
                if(items.get(i).getName().equals(name)) {
                    items.remove(i);
                }
            }
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

        public Room getRandomNeighbor() {
            if(neighbors.size() == 0) {
                return null;
            }

            int i = (int)(Math.random()*neighbors.size());
            return neighbors.get(i);
        }

        public boolean hasNeighbor(Room r) {

            for(int i = 0; i < neighbors.size(); i++) {
                if(r.equals(neighbors.get(i))) {
                    return true;
                }
            }

            return false;
        }

        public String getItems() {
            String output = "";
            for(int i = 0; i < items.size(); i++) {
                output += items.get(i).getName() + " ";
            }

            return output;
        }

        public ArrayList<Room> getNeighbors(){
            return neighbors;
        }

        @Override
        public String toString() {
            return this.getName();
        }
    }
}
