public class Bedroom extends Room {


    private int bedroomNumber;
    private RoomType type;

    public Bedroom(int capacity, int bedroomNumber, RoomType type){
        super(capacity);
        this.bedroomNumber = bedroomNumber;
        this.type = type;
    }

    public int getBedroomNumber() {
        return bedroomNumber;
    }

    public RoomType getType() {
        return type;
    }

}
