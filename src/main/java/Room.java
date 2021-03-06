import java.util.ArrayList;

public class Room {

    private int capacity;
    private ArrayList<Guest> guests;
    private boolean chargeable;

    public Room (int capacity, boolean chargeable){
        this.capacity = capacity;
        guests = new ArrayList<>();
        this.chargeable = chargeable;
    }

    public Room(int capacity){
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

    public boolean isChargeable() {
        return this.chargeable;
    }

    public void setChargeable(boolean chargeable) {
        this.chargeable = chargeable;
    }

    public void addGuestToRoom(Guest guest) {
        guests.add(guest);
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public void removeGuestFromRoom(Guest guestToRemove) {
        guests.remove(guestToRemove);
    }
}
