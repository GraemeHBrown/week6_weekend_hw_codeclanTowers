import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedRooms;
    private ArrayList<DiningRoom> diningRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(String name) {
        this.name = name;
        bedRooms = new ArrayList<>();
        diningRooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bedroom> getBedRooms() {
        return this.bedRooms;
    }

    public ArrayList<DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void manageBedrooms(Bedroom bedRoom, String action){
        if (action .equals("ADD")){
            bedRooms.add(bedRoom);
        } else if (action .equals("REMOVE")){
            bedRooms.remove(bedRoom);
        }
    }

    public String checkInGuests(ArrayList<Guest> guests) {
        String checkInMessage;
        int numberOfGuestsToCheckIn = guests.size();
        Bedroom roomToFill = findAvailableRoomForGuests(numberOfGuestsToCheckIn);
        if (roomToFill != null) {
            for (Guest guest : guests) {
                roomToFill.addGuestToRoom(guest);
            }
            checkInMessage = "Successful check in.";
        } else {
            checkInMessage = "Sorry no rooms available.";
        }
        return checkInMessage;

    }

    private Bedroom findAvailableRoomForGuests(int numberOfGuestsToCheckIn) {
        for (Bedroom room : bedRooms) {
            if (room.getCapacity() >= numberOfGuestsToCheckIn && room.guestCount() == 0) {
                return room;
            }
        }
        return null;
    }

}


//TODO check which guests are in a bedroom passing in bedroom number?
