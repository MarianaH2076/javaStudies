import entities.Room;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many rooms will be rented? ");
        int roomsToBeRented = sc.nextInt();

        Room[] rooms = new Room[10];

        for(int i = 0; i < roomsToBeRented; i++){
            System.out.println("Rent #" + (i+1));
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int room = sc.nextInt();

            rooms[room] = new Room(name, email, room);
        }

        System.out.println("Busy rooms:");
        for(int i = 0; i < rooms.length; i++){
//            System.out.println(rooms);
            if(rooms[i] != null){
                System.out.println(rooms[i].getRoom() + ": " + rooms[i].getName() + ", " + rooms[i].getEmail());
            }
        }


    }
}