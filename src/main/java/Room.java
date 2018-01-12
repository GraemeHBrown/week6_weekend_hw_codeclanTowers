import java.util.ArrayList;

public class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public Room (int capacity){
        this.capacity = capacity;
        guests = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int guestCount() {
        return this.guests.size();
    }
}
