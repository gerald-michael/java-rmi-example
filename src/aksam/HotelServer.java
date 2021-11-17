//package rooms;

import java.rmi.Naming;
/***
 * Class HotelServer to handle Server Logic to which the client will pass the massage
 */
public class HotelServer {
    public HotelServer() {
        try {

            RoomManager r = new RoomManagerImpl();
            // binding the server to the rmiregistry
            Naming.rebind("rmi://localhost:1099/hotelservice", r);
        } catch (Exception e) {
            System.out.println("Trouble: _" + e);
        }
    }
    public static void main (String args[] ) {
        // set the defaults
        new DataStorage().setRoomsData();
        new DataStorage().setBookedRooms();
        new HotelServer();

    }
}
