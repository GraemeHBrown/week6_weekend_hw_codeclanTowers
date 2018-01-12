import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HotelTest {

    Hotel hotel;

    @Before
    public void before(){
        hotel = new Hotel("Balmoral");
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
    public void hotelHasListOfRooms(){
        assertNotNull(hotel.getRooms());
    }

}
