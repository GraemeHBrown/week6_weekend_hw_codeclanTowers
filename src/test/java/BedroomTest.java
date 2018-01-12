import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;

    @Before
    public void before(){
        bedroom = new Bedroom(2, 101, RoomType.DOUBLE);
    }

    @Test
    public void bedroomHasCapacity(){
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void bedroomHasNumber(){
        assertEquals(101, bedroom.getBedroomNumber());
    }

    @Test
    public void bedroomHasType(){
        assertEquals(RoomType.DOUBLE, bedroom.getType());
    }

    @Test
    public void bedroomTypeHasCapacityValue(){
        assertEquals(RoomType.DOUBLE.getRoomCapacity(), bedroom.getType().getRoomCapacity());
    }
}
