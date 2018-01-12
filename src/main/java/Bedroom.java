public class Bedroom extends Room {


    private int bedroomNumber;
    //TODO add type constant

    public Bedroom(int capacity, int bedroomNumber){
        super(capacity);
        this.bedroomNumber = bedroomNumber;
    }

    public int getBedroomNumber() {
        return bedroomNumber;
    }
}
