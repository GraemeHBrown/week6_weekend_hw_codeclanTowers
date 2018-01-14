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
    public void checkingGuestIntoBedroomIncreasesGuestCountForRoomByTheNumberOfGuestsCheckedIn(){
        int bedroom1GuestCountBefore = bedroom1.guestCount();
        int guestCount = guests.size();
        hotel.checkInGuests(guests);
        assertEquals(bedroom1GuestCountBefore+guestCount, bedroom1.guestCount());
    }

    @Test
    public void checkingGuestIntoHotelWithoutSpaceDoesNotIncreaseGuestCountForRoom(){
        int bedroom1GuestCountBefore = bedroom1.guestCount();
        hotel.checkInGuests(partyTooLargeForAvailability);
        assertEquals(bedroom1GuestCountBefore, bedroom1.guestCount());
    }

    @Test
    public void attemptingToCheckGuestsIntoHotelWithoutSpaceDoesNotIncreaseOccupiedRoomCount(){
        int occupiedRoomCountBefore = hotel.getOccupiedBedRooms().size();
        hotel.checkInGuests(partyTooLargeForAvailability);
        assertEquals(occupiedRoomCountBefore, hotel.getOccupiedBedRooms().size());
    }

    @Test
    public void attemptingToCheckGuestsIntoHotelWithoutSpaceDoesNotDecreaseAvailableRoomCount(){
        int availableRoomCountBefore = hotel.getAvailableBedRooms().size();
        hotel.checkInGuests(partyTooLargeForAvailability);
        assertEquals(availableRoomCountBefore, hotel.getAvailableBedRooms().size());
    }

    @Test
    public void addingABedroomUsingManageAvailableBedroomsMethodIncreasesBedroomCount(){
        int availableBedroomCountBefore = hotel.getAvailableBedRooms().size();
        hotel.manageAvailableBedrooms(bedroom2,RoomManagementActions.ADD);
        assertEquals(availableBedroomCountBefore+1, hotel.getAvailableBedRooms().size());
    }

    @Test
    public void checkingGuestsIntoRoomDecreasesNumberOfAvailableRooms(){
        int availableBedroomCountBefore = hotel.getAvailableBedRooms().size();
        hotel.checkInGuests(guests);
        assertEquals(availableBedroomCountBefore-1, hotel.getAvailableBedRooms().size());
    }

    @Test
    public void checkingGuestsIntoRoomIncreasesTheNumberOfOccupiedRooms(){
        int occupiedBedroomCountBefore = hotel.getOccupiedBedRooms().size();
        hotel.checkInGuests(guests);
        assertEquals(occupiedBedroomCountBefore+1, hotel.getOccupiedBedRooms().size());
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

    @Test
    public void checkingOutGuestsFromRoomSetsRoomGuestCountToZero(){
        hotel.checkOutGuests(1);
        assertEquals(0, bedroom1.guestCount());
    }

    @Test
    public void checkingOutGuestsFromRoomDecreasesOccupiedRoomCount(){
        hotel.checkInGuests(guests);
        int occupiedRoomCount = hotel.getOccupiedBedRooms().size();
        hotel.checkOutGuests(1);
        assertEquals(occupiedRoomCount-1, hotel.getOccupiedBedRooms().size());
    }

    @Test
    public void checkingOutGuestsFromRoomIncreaseAvailableRoomCount(){
        hotel.checkInGuests(guests);
        int availableRoomCount = hotel.getAvailableBedRooms().size();
        hotel.checkOutGuests(1);
        assertEquals(availableRoomCount+1, hotel.getAvailableBedRooms().size());
    }

    @Test
    public void successfullyCheckingOutGuestsResultsInSuccessMessage(){
        hotel.checkInGuests(guests);
        String message = hotel.checkOutGuests(1);
        assertEquals("Guests successfully checked out.", message);
    }

    @Test
    public void canListVacantBedrooms(){
        assertEquals(1, hotel.getAvailableBedRooms().size());
    }

    @Test
    public void vacantRoomsHaveGuestListOfZero(){
        assertEquals(0, hotel.getAvailableBedRooms().get(0).guestCount());
    }


}
