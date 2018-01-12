import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;

    @Before
    public void before(){
        bedroom = new Bedroom(2, 101);
    }

    @Test
    public void bedroomHasCapacity(){
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void bedroomHasNumber(){
        assertEquals(101, bedroom.getBedroomNumber());
    }
}
