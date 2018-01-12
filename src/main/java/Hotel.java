import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        rooms = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

}
