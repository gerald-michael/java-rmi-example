
import java.io.IOException;
import java.rmi.*;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author root
 */
public interface RoomManager extends Remote {
    
    public void initialize() throws RemoteException; 
    //public int list(HashMap roomType0) throws RemoteException;
    public int book(int roomType,String guestName) throws RemoteException, IOException ;
    public List guests() throws RemoteException;
    public int[] revenue() throws RemoteException;
    
}
