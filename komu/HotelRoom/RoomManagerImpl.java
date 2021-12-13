import java.io.*;
import java.rmi.*;
import java.awt.*;
import java.util.*;
import java.text.DecimalFormat;
import java.applet.*;

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager{
String m_strName;
    public RoomManagerImpl() throws RemoteException{
        super();
    }

    public String roomList(int y, String z, String x) throws RemoteException{
        return Integer.toString(y) + " room(s) of type " + z + " are available for "+ x +" per night";
    }

public String book(int roomType, String guestName, String price)throws RemoteException{
  try{
    
    FileWriter myWriter = new FileWriter("guestList.txt", true);
    FileWriter revenueFile = new FileWriter("revenueFile.txt", true);
    FileWriter roomFile = new FileWriter("roomFile.txt", true);
    myWriter.write(Integer.toString(roomType)+"  "+guestName +"\n");

revenueFile.write(price+ "\n");
roomFile.write(roomType+ "\n");
myWriter.close();
revenueFile.close();
roomFile.close();
  } 
  catch(Exception e){
      e.printStackTrace();
  } 
  DecimalFormat decimalformat = new DecimalFormat("#,###");
        int finalPrice = Integer.parseInt(price);
        return "You have successfully booked a room of type "+roomType +" under the name "+guestName+" at a cost of "+ decimalformat.format(finalPrice)+" UGX for a single night";

}

public String guestList(String data) throws RemoteException{
    return data;
}

public String revenue(String data) throws RemoteException{
    return data;
}
}
