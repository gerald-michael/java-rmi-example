
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */
public class HotelServer extends RoomManagerImpl { 
        
        private static final long serialVersionUID = 487308;

    /**
     *
     * @throws RemoteException
     */
    public HotelServer() throws RemoteException
        {
            super();
        }
        
	public static void main(String[] args) throws RemoteException, Exception
        {
            try 
            {
                RoomManagerImpl rm = new RoomManagerImpl();
                
                //Initializing the HashMapOfType0 and serializing the HashMap
                rm.initialize();
                
                //Creating the registry
                
                Registry registry = LocateRegistry.createRegistry(1099);

                    // Create an object of the interface
                    // implementation class
    //		Impl obj = new Impl();

                    // Binds the remote object by the name ADD
                    Naming.bind("rmi://localhost:1099/RoomService",rm);

                    System.out.println("Server Started");
            }
            catch(RemoteException e)
            {
                
            }
        }
}
            
        
    
    

