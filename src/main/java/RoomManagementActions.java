public enum RoomManagementActions {

    ADD("add"),
    REMOVE("remove");

    private String action;

    RoomManagementActions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
