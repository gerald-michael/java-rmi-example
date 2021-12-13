import java.io.*;
import java.rmi.*;
import java.util.List;

public interface RoomManager extends Remote{

    //book
    //list
    //guests
    //revenue
public String roomList(int y, String z, String x) throws RemoteException;

public String book(int roomType, String guestName, String price)throws RemoteException; 

public String guestList(String data) throws RemoteException;

public String revenue(String data) throws RemoteException;

    
    
}
