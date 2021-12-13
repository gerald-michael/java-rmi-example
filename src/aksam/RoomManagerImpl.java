//package rooms;

import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/***
*
* Contains the implementation logic of the {@link RoomManager} interface
*
 */
public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager{
    public RoomManagerImpl() throws RemoteException {
        super();
    }            

    @Override
    public ArrayList<Room> getAvailableRooms() throws RemoteException  {
        // the list to store the objects
      ArrayList<Room> list=new ArrayList<>();
       // retrieving data stored
        HashMap<Integer, Room> rooms=new DataStorage().getRoomsData();
        // looping through to add each room into the list
        for(Map.Entry room : rooms.entrySet()){
           list.add((Room) room.getValue());
        }

        return list;
    }


    @Override
    public boolean bookRoom(int type, String name) throws RemoteException {
       int available=0;
        // get value of key
        Room roomData = (Room)DataStorage.roomsData.get(type);
        Room bookedRoomData=(Room)DataStorage.bookedRooms.get(type);

        available=roomData.getAvailable();
        if(available>0){
            available=available-1;
            DataStorage.roomsData.put(type,new Room(type,roomData.getPrice(),available));
            bookedRoomData.setAvailable(bookedRoomData.getAvailable()+1);
            DataStorage.bookedRooms.put(type,bookedRoomData);
            new DataStorage().saveGuest(name);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ArrayList<String> getGuests() throws RemoteException {
         return DataStorage.guestsList;
    }

    @Override
    public ArrayList<String> computeRevenue() throws RemoteException, ParseException {
        // looping through to add each room into the list
        ArrayList<String> list=new ArrayList<>();
        for(Map.Entry bookedRoom : DataStorage.bookedRooms.entrySet()){
            Room room= (Room) bookedRoom.getValue();
            NumberFormat nf=NumberFormat.getInstance();
           int price= nf.parse(room.getPrice()).intValue();
           int bookedRooms=room.getAvailable();
           int revenue=price * bookedRooms;
           list.add(bookedRooms+" booked rooms of type "+room.getType()+" have a total revenue "+revenue+" UGX.");
        }
        return list;
    }


}
