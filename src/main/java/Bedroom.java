import java.math.BigDecimal;
import java.util.Currency;

public class Bedroom extends Room {


    private int bedroomNumber;
    private RoomType type;
    private BigDecimal rate;

    public Bedroom(int capacity, int bedroomNumber, RoomType type, boolean chargeable, BigDecimal rate){
        super(capacity, chargeable);
        this.bedroomNumber = bedroomNumber;
        this.type = type;
        this.rate = rate;
    }

    public int getBedroomNumber() {
        return bedroomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
