public enum RoomType {

    SINGLE(1, "Single"),
    DOUBLE(2, "Double");

    private int roomCapacity;
    private String type;

    RoomType(int roomCapacity, String type){
        this.roomCapacity = roomCapacity;
        this.type = type;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }


    public String getType() {
        return type;
    }
}
