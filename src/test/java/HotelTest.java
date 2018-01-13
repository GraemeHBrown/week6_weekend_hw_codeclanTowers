import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HotelTest {

    Hotel hotel;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    ArrayList<Guest> guests;
    ArrayList<Guest> partyTooLargeForAvailability;
    Bedroom bedroom1;

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
        hotel.manageBedrooms(bedroom1,"ADD");

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
        assertNotNull(hotel.getBedRooms());
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


}
