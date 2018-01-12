import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(30,"Orkney", true);
    }

    @Test
    public void conferenceRoomHasName() {
        assertEquals("Orkney", conferenceRoom.getName());
    }

    @Test
    public void canSetConferenceRoomName() {
        conferenceRoom.setName("Shetland");
        assertEquals("Shetland", conferenceRoom.getName());
    }

    @Test
    public void conferenceRoomHasCapacity(){
        assertEquals(30, conferenceRoom.getCapacity());
    }

}

