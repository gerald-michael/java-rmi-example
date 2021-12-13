import java.rmi.Naming;

public class HotelServer {
    public HotelServer (){
        try{
            RoomManagerImpl RMI = new RoomManagerImpl();
            Naming.rebind("rmi://localhost:1099/hotelservice", RMI);
        }
        catch (Exception e){
            System.out.println("Trouble: _" + e);
        }
    }

    public static void main(String args[]){
        new HotelServer ();
        System.out.println("Server started successfully");
    }
    
}
