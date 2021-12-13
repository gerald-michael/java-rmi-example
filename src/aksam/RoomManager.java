//package rooms;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
/***
*
* RoomManager interface contains the methods to manage rooms
*
 ***/

public interface RoomManager  extends Remote { 

    /***
     * list all the available rooms
     * @return
     ***/
    public ArrayList<Room> getAvailableRooms() throws RemoteException;

    /***
     * book a room  with a room type
     * @return
     ***/
    public boolean bookRoom(int type,String name) throws RemoteException;

    /***
     * Prints  all guests that booked rooms
     * @return
     ***/
    public ArrayList<String> getGuests()throws RemoteException;

    /***
     * computes and prints  revenue for a night   based on the booked rooms and their types
     * @return
     ***/
    public ArrayList<String> computeRevenue() throws RemoteException, ParseException;

}
