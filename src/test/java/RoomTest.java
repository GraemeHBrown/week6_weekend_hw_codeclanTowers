import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoomTest {

    Room room;


    @Before
    public void before(){
        room = new Room(2,true);
    }

    @Test
    public void roomHasCapacity(){
        assertEquals(2, room.getCapacity());
    }

    @Test
    public void canSetRoomCapacity(){
        room.setCapacity(3);
        assertEquals(3, room.getCapacity());
    }

    @Test
    public void roomHasListOfGuests(){
        assertNotNull( room.guestCount());
    }

    @Test
    public void roomWithoutGuestsCheckedInIsEmpty(){
        assertEquals(0, room.guestCount());
    }


}
