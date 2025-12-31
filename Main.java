import java.util.Scanner;
import java.util.ArrayList;

class Room {
    int roomNumber;
    String type; 
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

public class Main {
    static ArrayList<Room> rooms = new ArrayList<>(); 
    static Scanner input = new Scanner(System.in); // Moved Scanner here to share it

    public static void main(String[] args) {
        // Initialize hotel rooms with different prices
        rooms.add(new Room(101, "Deluxe", 2500));
        rooms.add(new Room(102, "Premium", 4000));
        rooms.add(new Room(103, "Suite", 6000));
        
        while(true) {
            System.out.println("\n--- HOTEL PAM PREMIUM SYSTEM ---");
            System.out.println("1. Check Availability");
            System.out.println("2. Book Room");
            System.out.println("3. Checkout & Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            
            if(input.hasNextInt()) {
                int choice = input.nextInt();
                
                if(choice == 1) {
                    checkAvailability();
                } else if(choice == 2) {
                    System.out.print("Enter Room Number: ");
                    int rNo = input.nextInt();
                    System.out.print("Enter Guest Name: ");
                    String name = input.next();
                    bookRoom(rNo, name);
                } else if(choice == 3) {
                     System.out.print("Enter Room Number to Checkout: ");
                     int rNo = input.nextInt();
                     checkoutRoom(rNo);
                } else {
                    System.out.println("Exiting System...");
                    break;
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                input.next(); 
            }
        }
    }

    public static void checkAvailability() {
        System.out.println("\n--- Available Rooms ---");
        boolean found = false;
        for(Room r : rooms) {
            if(!r.isBooked) {
                System.out.println("Room " + r.roomNumber + " [" + r.type + "] - Rs." + r.price + "/night");
                found = true;
            }
        }
        if(!found) System.out.println("No rooms available!");
    }
    
    public static void bookRoom(int roomNum, String name) {
        for(Room r : rooms) {
            if(r.roomNumber == roomNum) {
                if(!r.isBooked) {
                    r.bookRoom(name);
                    System.out.println("Success! Room " + roomNum + " booked for " + name);
                } else {
                    System.out.println("Error: Room " + roomNum + " is already occupied.");
                }
                return;
            }
        }
        System.out.println("Error: Room number not found.");
    }

    public static void checkoutRoom(int roomNum) {
        for(Room r : rooms) {
            if(r.roomNumber == roomNum) {
                if(r.isBooked) {
                    // NEW: Ask for duration to calculate bill
                    System.out.print("Enter number of days stayed: ");
                    int days = input.nextInt();
                    
                    double totalBill = r.price * days;
                    
                    System.out.println("\n--- CHECKOUT SUMMARY ---");
                    System.out.println("Guest Name: " + r.guestName);
                    System.out.println("Room Type: " + r.type);
                    System.out.println("Days Stayed: " + days);
                    System.out.println("Total Amount Due: Rs. " + totalBill);
                    System.out.println("------------------------");
                    
                    r.checkout(); // Clear the room status
                } else {
                    System.out.println("Error: Room " + roomNum + " is already empty.");
                }
                return;
            }
        }
        System.out.println("Error: Room number not found.");
    }
}
