import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    BigDecimal testRate;
    BigDecimal raisedRate;

    @Before
    public void before(){
        testRate = new BigDecimal("95.00");
        raisedRate = new BigDecimal("98.00");
        bedroom = new Bedroom(2, 101, RoomType.DOUBLE, true, testRate);
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

    @Test
    public void bedroomHasRate(){
        assertEquals(testRate, bedroom.getRate());
    }

    @Test
    public void canSetBedroomRate(){
        bedroom.setRate(raisedRate);
        assertEquals(raisedRate, bedroom.getRate());
    }
}
