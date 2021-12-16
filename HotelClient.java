
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

 @SuppressWarnings("unchecked")


public class HotelClient {
    
    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException, IOException
    {
        try{
		
            System.out.println("****Welcome to the HotelRoomReservation System**** ");
            System.out.println("---------------------------------------------------");
            System.out.println("Choose from the available menu options for service!");
            System.out.println("1. Enter \"List\" to display the available number of rooms in each price range");
            System.out.println("2. Enter \"Book\" to reserve a room of specified type (if available) and register the name of the guest");
            System.out.println("3. Enter \"Guest\" to list the names of all registered guests");
            System.out.println("4. Enter \"Revenue\" to print the revenue breakdown based on the booked rooms and their types.\n");
            
            
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String option;
            option = br.readLine();
            
            RoomManager rm = (RoomManager)Naming.lookup("rmi://localhost:1099/RoomService");
            
            switch(option){
            
//                case("list"): 
//                    
//                    HashMap<Integer, String> roomType0 = null;
//                    HashMap<Integer, String> roomType1 = null;
//                    HashMap<Integer, String> roomType2 = null;
//                    HashMap<Integer, String> roomType3 = null;
//                    HashMap<Integer, String> roomType4 = null;
//                    
//
//		try {
//			FileInputStream fileInput0 = new FileInputStream("/home/house/Downloads/Javame/newHashMap0.txt");
//
//			ObjectInputStream objectInput0 = new ObjectInputStream(fileInput0);
//
//			roomType0 = (HashMap)(objectInput0.readObject());
//                        
//                  int count0 = rm.list(roomType0);
//                  System.out.println(count0 + " rooms of type0 are available for 55,000 UGX per night");
//                  
//                        objectInput0.close();
//                        fileInput0.close();
//                }
//                  catch (ClassNotFoundException ex) {
//                Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//                try {
//                        
//                        FileInputStream fileInput1 = new FileInputStream("/home/house/Downloads/Javame/newHashMap1.txt");
//
//			ObjectInputStream objectInput1 = new ObjectInputStream(fileInput1);
//
//			roomType1 = (HashMap)objectInput1.readObject();
//                   
//                        int count1 = rm.list(roomType1);
//                        System.out.println(count1 + " rooms of type1 are available for 75,000 UGX per night");
//
//                              objectInput1.close();
//                              fileInput1.close();                     
//                }
//                catch (ClassNotFoundException ex) {
//                Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//                
//                try {
//			FileInputStream fileInput2 = new FileInputStream("/home/house/Downloads/Javame/newHashMap2.txt");
//
//			ObjectInputStream objectInput2 = new ObjectInputStream(fileInput2);
//
//			roomType2 = (HashMap)objectInput2.readObject();
//                       
//                        int count2 = rm.list(roomType2);
//                        System.out.println(count2 + " rooms of type2 are available for 80,000 UGX per night");
//
//                              objectInput2.close();
//                              fileInput2.close();
//                }
//                  catch (ClassNotFoundException ex) {
//                Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                    
//                
//                
//                try {
//			FileInputStream fileInput3 = new FileInputStream("/home/house/Downloads/Javame/newHashMap3.txt");
//
//			ObjectInputStream objectInput3 = new ObjectInputStream(fileInput3);
//
//			roomType3 = (HashMap)objectInput3.readObject();
//
//                        int count3 = rm.list(roomType3);
//                        System.out.println(count3 + " rooms of type3 are available for 150,000 UGX per night");
//
//                              objectInput3.close();
//                              fileInput3.close();
//                }
//                  catch (ClassNotFoundException ex) {
//                Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                    
//                
//                
//                try {
//			FileInputStream fileInput4 = new FileInputStream("/home/house/Downloads/Javame/newHashMap4.txt");
//
//			ObjectInputStream objectInput4 = new ObjectInputStream(fileInput4);
//
//			roomType4 = (HashMap)objectInput4.readObject();
//                        
//                        int count4 = rm.list(roomType4);
//                        System.out.println(count4 + " rooms of type4 are available for 230,000 UGX per night");
//
//                              objectInput4.close();
//                              fileInput4.close();
//                }
//                  catch (ClassNotFoundException ex) {
//                Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//                    break;
                    
                case("book"):  
                    
                    System.out.print("Enter Guest Name: ");
                    String guestName = br.readLine();
                    System.out.print("Enter Room Type: ");
                    int roomType = Integer.parseInt(br.readLine());
                    
                    int available = rm.book(roomType, guestName);
                    if(available > 0){
                        System.out.println(guestName + " has booked room number: " + available + " of type"+roomType);
                    }
                    else
                    {
                        System.out.println("\nSORRY! ALL type"+roomType + " rooms are Occupied.\n");
                    }
              
                    
                    break;
                 
                case("guests"):
                    
                    System.out.println("A List of All Registered Guests:");
                    List<String> listAll;
                
                    listAll = rm.guests();
                    
                    Iterator<String> iter= listAll.iterator();
                    
                    int counter = 1;
                    while(iter.hasNext()) 
                    {
                        System.out.println(counter+ ". " + iter.next());
                        counter++;
                    }
                    break;

                    
                case("revenue"):
                    
                    int[] arr = rm.revenue();
                    int revenue0 = arr[0] * 55000;
                    int revenue1 = arr[1] * 75000;
                    int revenue2 = arr[2] * 80000;
                    int revenue3 = arr[3] * 150000;
                    int revenue4 = arr[4] * 230000;
                  
                    System.out.println("Type0  Number of rooms: " + arr[0] + "  Revenue: " + revenue0);
                    System.out.println("Type1  Number of rooms: " + arr[1] + "  Revenue: " + revenue1);
                    System.out.println("Type2  Number of rooms: " + arr[2] + "  Revenue: " + revenue2);
                    System.out.println("Type3  Number of rooms: " + arr[3] + "  Revenue: " + revenue3);
                    System.out.println("Type4  Number of rooms: " + arr[4] + "  Revenue: " + revenue4);
                    
                    break;
                    
                default:
                    System.out.println("\nPlease Enter a valid command from the available Menu options.\n");
            } 
        }
        catch(RemoteException e)
        {
            System.out.println("Received Exception"+e);
        }     
    }
}
