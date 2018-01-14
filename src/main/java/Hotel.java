import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> availableBedRooms;
    private ArrayList<Bedroom> occupiedBedRooms;
    private ArrayList<DiningRoom> diningRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(String name) {
        this.name = name;
        availableBedRooms = new ArrayList<>();
        occupiedBedRooms = new ArrayList<>();
        diningRooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bedroom> getAvailableBedRooms() {
        return this.availableBedRooms;
    }

    public ArrayList<Bedroom> getOccupiedBedRooms() {
        return occupiedBedRooms;
    }

    public ArrayList<DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void manageAvailableBedrooms(Bedroom bedRoom, RoomManagementActions action) {
        if (action.equals(RoomManagementActions.ADD)) {
            availableBedRooms.add(bedRoom);
        } else if (action.equals(RoomManagementActions.REMOVE)) {
            availableBedRooms.remove(bedRoom);
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
            manageAvailableBedrooms(roomToFill, RoomManagementActions.REMOVE);
            manageOccupiedBedrooms(roomToFill, RoomManagementActions.ADD);
            checkInMessage = "Successful check in.";
        } else {
            checkInMessage = "Sorry no rooms available.";
        }
        return checkInMessage;

    }

    public void manageOccupiedBedrooms(Bedroom bedroom, RoomManagementActions action) {
        if (action.equals(RoomManagementActions.ADD)) {
            occupiedBedRooms.add(bedroom);
        } else if (action.equals(RoomManagementActions.REMOVE)) {
            occupiedBedRooms.remove(bedroom);
        }
    }

    public ArrayList<Guest> findGuestsForRoom(int roomNumber) {
        ArrayList<Guest> guestsCheckedIntoRoom = new ArrayList<>();
        for (Bedroom occupiedRoom : occupiedBedRooms) {
            if (roomNumber == occupiedRoom.getBedroomNumber()) {
                guestsCheckedIntoRoom = occupiedRoom.getGuests();
            }
        }
        return guestsCheckedIntoRoom;
    }

    public String checkOutGuests(int roomNumber) {
        String checkOutMessage;
        Bedroom roomToCheckOutFrom = findRoomByRoomNumber(roomNumber);
        if (roomToCheckOutFrom != null) {
            for (Guest guestToCheckOut : roomToCheckOutFrom.getGuests()) {
                roomToCheckOutFrom.removeGuestFromRoom(guestToCheckOut);
            }
            manageAvailableBedrooms(roomToCheckOutFrom, RoomManagementActions.ADD);
            manageOccupiedBedrooms(roomToCheckOutFrom, RoomManagementActions.REMOVE);
            checkOutMessage = "Guests successfully checked out.";
        } else {
            checkOutMessage = "Sorry there has been a problem with checkout!";
        }
        return checkOutMessage;
    }

    @Nullable
    private Bedroom findRoomByRoomNumber(int roomNumber) {
        for (Bedroom roomToCheckOutFrom : occupiedBedRooms) {
            if (roomNumber == roomToCheckOutFrom.getBedroomNumber()) {
                return roomToCheckOutFrom;
            }
        }
        return null;
    }

    @Nullable
    private Bedroom findAvailableRoomForGuests(int numberOfGuestsToCheckIn) {
        for (Bedroom room : availableBedRooms) {
            if (room.getCapacity() >= numberOfGuestsToCheckIn && room.guestCount() == 0) {
                return room;
            }
        }
        return null;
    }


}



