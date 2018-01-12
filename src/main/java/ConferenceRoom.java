public class ConferenceRoom extends Room {


    private String name;

    public ConferenceRoom(int capacity, String name, boolean chargeable) {
        super(capacity, chargeable);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
