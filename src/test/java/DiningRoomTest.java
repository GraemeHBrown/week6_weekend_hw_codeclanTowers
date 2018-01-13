import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;

    @Before
    public void before(){
        diningRoom = new DiningRoom(100);
    }

    @Test
    public void diningRoomHasCapacity(){
        assertEquals(100, diningRoom.getCapacity());
    }
}
