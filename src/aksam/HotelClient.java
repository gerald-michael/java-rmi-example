///package rooms;

import java.rmi.Naming;

public class HotelClient {

    public static void main (String [] args) {
        // no arguments supplied
        if (args.length==0) {
            System.out.println("**************Welcome to Our hotel************ ,\n Use the commands below to do anything you feel like\n");
            System.out.println("\n\n\t java HotelClient list <server address>: list the available number of rooms in each price");
            System.out.println("\n\n \t java HotelClient book <server address> <room type> <guest name>: books a \n" +
                    "room of the specified type (if available)\n");
            System.out.println("\n\n \t java HotelClient guests <server address>: list the names of all the registered guests");
            System.out.println("\n\n\t java HotelClient revenue <server address>: prints the revenue breakdown based on \n"+
            "the booked rooms and their types.");
        } else {
           
            try {
                RoomManager c = null;
                // display lists
                if (args[0].equals("list") && args.length==2) {
                    String serverAddress=args[1].toString();
                    c=(RoomManager)Naming.lookup("rmi://"+serverAddress+":1099/hotelservice");
                    System.out.println("\n");
                   for (Room room : c.getAvailableRooms()) {
                    int available=room.getAvailable();
                       int roomType= room.getType();
                       String price = room.getPrice();

                       System.out.println("\t\t"+available+" rooms of type " + roomType + " are available for " + price + " UGX per night");


                   }

                }
                // book a room
                else if (args[0].equals("book") && args.length==4){
                    String serverAddress=args[1].toString();
                    c=(RoomManager)Naming.lookup("rmi://"+serverAddress+":1099/hotelservice");
                    int roomType= Integer.parseInt(args[2]);
                    String guestName=args[3];
                    // check if its a valid room type

                    if(roomType<0 || roomType>4){
                     System.out.println("The room type isn't a valid one ;0,1,2,3,4");
                    }
                    else if(c.bookRoom(roomType,guestName)){
                        System.out.println("room booked by "+guestName);
                    }else{
                        System.out.println("No available room for the selected type.");
                    }

                }
                // handle guests
                else if (args[0].equals("guests")&& args.length==2){
                    String serverAddress=args[1].toString();
                    c=(RoomManager)Naming.lookup("rmi://"+serverAddress+":1099/hotelservice");
                    if(c.getGuests().size()<1){
                        System.out.println("No guest Available");
                    }else {

                        for (String guest : c.getGuests()) {
                            System.out.println(guest);
                        }
                    }
                }
                // handle revenue
                else if(args[0].equals("revenue")&& args.length==2){
                    String serverAddress=args[1].toString();
                    c=(RoomManager)Naming.lookup("rmi://"+serverAddress+":1099/hotelservice");
                    for (String revenue : c.computeRevenue()) {
                        System.out.println(revenue);
                    }
                }
                // for cases where the user supplied invalid arguments
                else {
                    System.out.println("Invalid argument : use this command  java HotelClient: to see the valid ones ");
                }
               // catch all exceptions 
            } catch (Exception e) {
                System.out.println("Received Exception: ");
                System.out.println(e);
            }
        }
    }
}
