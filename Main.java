import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Room> rooms = new ArrayList<>(); // Stores all rooms

    public static void main(String[] args) {
        // Initialize some rooms
        rooms.add(new Room(101, "Deluxe", 2500));
        rooms.add(new Room(102, "Premium", 4000));
        
        Scanner input = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n--- HOTEL PAM MANAGER ---");
            System.out.println("1. Check Availability");
            System.out.println("2. Book Room");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            
            int choice = input.nextInt();
            
            if(choice == 1) {
                checkAvailability();
            } else if(choice == 2) {
                // Logic to ask for room number and name
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
                break;
            }
        }
    }

    // Helper method to show empty rooms
    public static void checkAvailability() {
        for(Room r : rooms) {
            if(!r.isBooked) {
                System.out.println("Room " + r.roomNumber + " (" + r.type + ") - Rs." + r.price);
            }
        }
    }
    
    // Helper method to book
    public static void bookRoom(int roomNum, String name) {
        for(Room r : rooms) {
            if(r.roomNumber == roomNum) {
                r.bookRoom(name);
                System.out.println("Success! Room booked for " + name);
                return;
            }
        }
        System.out.println("Room not found.");
    }

    // Helper method to checkout
    public static void checkoutRoom(int roomNum) {
        for(Room r : rooms) {
            if(r.roomNumber == roomNum) {
                r.checkout();
                System.out.println("Checkout Complete. Bill: Rs." + r.price);
                return;
            }
        }
    }
}
