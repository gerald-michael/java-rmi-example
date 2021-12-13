//package rooms;

import java.util.ArrayList;
import java.util.HashMap;

/*
--- Handle the localStorage Data for rooms and guests
*/
public class DataStorage {
        // to handle data for rooms
        public static HashMap<Integer, Room> roomsData = new HashMap<Integer,Room>();
        //to handle data for guests
        public static ArrayList<String> guestsList=new ArrayList<>();
        // to handle data for booked rooms
        public static HashMap<Integer, Room> bookedRooms = new HashMap<Integer,Room>();
        
        // return data for available rooms 
        public HashMap<Integer, Room>getRoomsData(){ 
            return roomsData;
        }
        //set the default data for rooms
        public  void setRoomsData(){
            roomsData.put(0,new Room(0,"55,000",10));
            roomsData.put(1,new Room(1,"75,000",20));
            roomsData.put(2,new Room(2,"80,000",5));
            roomsData.put(3,new Room(3,"150,000",3));
            roomsData.put(4,new Room(4,"230,000",2));
        }
        //set the default data for bookedRooms
        public  void setBookedRooms(){
        bookedRooms.put(0,new Room(0,"55,000",0));
        bookedRooms.put(1,new Room(1,"75,000",0));
        bookedRooms.put(2,new Room(2,"80,000",0));
        bookedRooms.put(3,new Room(3,"150,000",0));
        bookedRooms.put(4,new Room(4,"230,000",0));
        }
        // save a new guest
        public void saveGuest(String name){
          guestsList.add(name);
        }

}
