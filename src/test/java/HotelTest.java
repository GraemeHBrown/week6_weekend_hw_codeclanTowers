import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HotelTest {

    Hotel hotel;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    ArrayList<Guest> guests;
    ArrayList<Guest> partyTooLargeForAvailability;
    Bedroom bedroom1;
    Bedroom bedroom2;

    @Before
    public void before(){
        hotel = new Hotel("Balmoral");
        guest1 = new Guest("Freddy Dodge");
        guest2 = new Guest("Todd Hoffman");
        guest3 = new Guest("Parker Schnabel");
        guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        partyTooLargeForAvailability = new ArrayList<>();
        partyTooLargeForAvailability.add(guest1);
        partyTooLargeForAvailability.add(guest2);
        partyTooLargeForAvailability.add(guest3);
        bedroom1 = new Bedroom(2, 1, RoomType.DOUBLE, true, BigDecimal.valueOf(95.00));
        bedroom2 = new Bedroom(1, 2, RoomType.SINGLE, true, BigDecimal.valueOf(65.00));
        hotel.manageAvailableBedrooms(bedroom1,RoomManagementActions.ADD);

    }

    @Test
    public void hotelHasName(){
        assertEquals("Balmoral", hotel.getName());
    }

    @Test
    public void canSetHotelName(){
        hotel.setName("The Balmoral");
        assertEquals("The Balmoral", hotel.getName());
    }

    @Test
    public void hotelHasListOfBedRooms(){
        assertNotNull(hotel.getAvailableBedRooms());
    }

    @Test
    public void hotelHasListOfDiningRooms(){
        assertNotNull(hotel.getDiningRooms());
    }

    @Test
    public void hotelHasListOfConferenceRooms(){
        assertNotNull(hotel.getConferenceRooms());
    }

    @Test
    public void checkingGuestIntoBedroomReturnsSuccessMessage(){
        assertEquals("Successful check in.", hotel.checkInGuests(guests));
    }

    @Test
    public void checkingGuestIntoHotelWithoutSpaceResultsInNoRoomsMessage(){
        assertEquals("Sorry no rooms available.", hotel.checkInGuests(partyTooLargeForAvailability));
    }

    @Test
    public void checkingGuestIntoBedroomIncreasesGuestCountForRoom(){
        hotel.checkInGuests(guests);
        assertEquals(2, bedroom1.guestCount());
    }

    @Test
    public void checkingGuestIntoHotelWithoutSpaceDoesNotIncreaseGuestCountForRoom(){
        hotel.checkInGuests(partyTooLargeForAvailability);
        assertEquals(0, bedroom1.guestCount());
    }

    @Test
    public void addingABedroomUsingManageAvailableBedroomsMethodIncreasesBedroomCount(){
        int bedroomCountBefore = hotel.getAvailableBedRooms().size();
        assertEquals(1,bedroomCountBefore);
        hotel.manageAvailableBedrooms(bedroom2,RoomManagementActions.ADD);
        assertEquals(bedroomCountBefore+1, hotel.getAvailableBedRooms().size());
    }

    @Test
    public void checkingGuestsIntoRoomRemovesItFromListOfAvailableRooms(){
        int bedroomCountBefore = hotel.getAvailableBedRooms().size();
        assertEquals(1,bedroomCountBefore);
        hotel.checkInGuests(guests);
        assertEquals(0, hotel.getAvailableBedRooms().size());
    }

    @Test
    public void checkingGuestsIntoRoomAddsItToListOfOccupiedRooms(){
        int bedroomCountBefore = hotel.getOccupiedBedRooms().size();
        assertEquals(0,bedroomCountBefore);
        hotel.checkInGuests(guests);
        assertEquals(1, hotel.getOccupiedBedRooms().size());
    }

    @Test
    public void findGuestForRoomReturnsAListOfGuests(){
        hotel.checkInGuests(guests);
        assertEquals(guests,hotel.findGuestsForRoom(1));
    }

    @Test
    public void checkedInGuestsReturnedByFindGuestsForRoomMethod(){
        hotel.checkInGuests(guests);
        assertTrue(hotel.findGuestsForRoom(1).contains(guest1));
        assertTrue(hotel.findGuestsForRoom(1).contains(guest2));
    }


}
