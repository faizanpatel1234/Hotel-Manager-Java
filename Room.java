public class Room {
    int roomNumber;
    String type; // e.g., "Premium", "Deluxe"
    double price;
    boolean isBooked;
    String guestName;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
        this.guestName = "";
    }

    public void bookRoom(String guestName) {
        this.isBooked = true;
        this.guestName = guestName;
    }

    public void checkout() {
        this.isBooked = false;
        this.guestName = "";
    }
}
