
import java.rmi.Naming;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.rmi.*;

public class HotelClient {
    public static void main(String [] args) throws Exception {
try{
    FileWriter myWriter = new FileWriter("guestList.txt", true);
    FileWriter revenueFile = new FileWriter("revenueFile.txt", true);
    FileWriter roomFile = new FileWriter("roomFile.txt", true);
    if( args.length ==0)
    {
        System.out.println("\t****Welcome to Our hotel. ****  Type any of these commands below to recieve a service.");
        System.out.println("\t java HotelClient list <server address>: Gives a list of the available number of rooms in each \n\t with it's price.");
        System.out.println("\t java HotelClient book <server address> <room type> <guest name>: Books a room of the specified type");
        System.out.println("\t java HotelClient guests <server address>: Gives a list of the names of all the registered guests.");
        System.out.println("\t java HotelClient revenue <server address>: Prints the revenue breakdown based on the booked"+
        " rooms \n\t and their types.");
    }
    else if(args[0].equals("list") && args.length==2) {
        String serverAddress=args[1].toString();
    
       File newFile = new File("roomFile.txt");
       FileInputStream fstream = new FileInputStream("roomFile.txt");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
       
       if(newFile.length() == 0){
           String roomList = 
           "\t We have 10 rooms of type 0 which are single rooms that costs 55,000 UGX a night\n\t We have 20 rooms of type 1 which are double rooms that costs 75,000 UGX a night \n\t We have 5 rooms of type 2 which are twin rooms that costs 80,000 UGX a night \n \t We have 3 rooms of type 3 which are triple rooms that costs 150,000 UGX a night \n \t We have 2 rooms of type 4 which are quad rooms that costs 230,000 UGX a night ";
            System.out.println(roomList);
       }
       String strLine=" ";
       String str=" ";
      while ((strLine = buffer.readLine()) != null)   {
  str = str + strLine;
      }
      String s=str.replaceAll(" ", " ");
 char[] M =s.toCharArray();
for(int counter =0; counter< M.length;counter++) {
    RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");
char ch = M[counter];
int count=0;
for ( int i=0; i< M.length; i++){
if (ch==M[i]){
  // System.out.println(ch);
  count++;
}
}
boolean flag=false;
for(int j=counter-1;j>=0;j--){
if(ch==M[j])
flag=true; 

}
if(!flag){
   String m = Character.toString(ch);
   if(m.equals("0")){
       int j = 10-count;
       String k =" 55,000 UGX ";
       System.out.println(RM.roomList(j,m,k));
   }
   if(m.equals("1")){
   int j = 20-count;
   String k = "75,000 UGX";
   System.out.println(RM.roomList(j,m,k));
   }
   if(m.equals("2")){
    int j = 5-count;
    String k = " 80,000 UGX ";
    System.out.println(RM.roomList(j,m,k));
  }
  if(m.equals("3")){
    int j = 3-count;
    String k = " 150,000 UGX";
    System.out.println(RM.roomList(j,m,k));
}
if(m.equals("4")){
    int j = 2-count;
    String k = " 230,000 UGX ";
    System.out.println(RM.roomList(j,m,k));
  }
    }
} }

else if (args[0].equals("guests") && args.length==2){
    String serverAddress=args[1].toString();
    RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");
    File guestFile = new File("guestList.txt");
    Scanner reader = new Scanner(guestFile);
    System.out.println("\n This is the list of available guests\n");
    while (reader.hasNextLine()){
        String data = reader.nextLine();
        System.out.println(RM.guestList(data));
    }
}
else if(args[0].equals("revenue") && args.length==2){
    String serverAddress=args[1].toString();
    RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");

    File revenue = new File("revenueFile.txt");
    Scanner reader = new Scanner(revenue);
    System.out.println("\nThis is the Hotel Revenue\n");
    while (reader.hasNextLine()){
        String data = reader.nextLine();
        System.out.println(RM.revenue(data));
    }
}
else if (args.length == 4){

 if(args[0].equals("book") && args[2].equals("0") && !args[3].isEmpty() ){
     String serverAddress=args[1].toString();
     RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");
     int d = Integer.parseInt(args[2]);
     String price = "55000";
     System.out.println(RM.book(d, args[3], price));
 }
 else if(args[0].equals("book") && args[2].equals("1") && !args[3].isEmpty() ){
    String serverAddress=args[1].toString();
    RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");
    int d = Integer.parseInt(args[2]);
    String price = "75000";
    System.out.println(RM.book(d, args[3], price));
 }
 else if(args[0].equals("book") && args[2].equals("2") && !args[3].isEmpty() ){
    String serverAddress=args[1].toString();
    RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");
    int d = Integer.parseInt(args[2]);
    String price = "80000";
    System.out.println(RM.book(d, args[3], price));
 }
 else if(args[0].equals("book") && args[2].equals("3") && !args[3].isEmpty() ){
    String serverAddress=args[1].toString();
    RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");
    int d = Integer.parseInt(args[2]);
    String price = "150000";
    System.out.println(RM.book(d, args[3], price));
 }
 else if(args[0].equals("book") && args[2].equals("4") && !args[3].isEmpty() ){
    String serverAddress=args[1].toString();
    RoomManager RM =(RoomManager) Naming.lookup("rmi://" + serverAddress + ":1099/hotelservice");
    int d = Integer.parseInt(args[2]);
    String price = "230000";
    System.out.println(RM.book(d, args[3], price));
 }

 BufferedReader reader =new BufferedReader(new FileReader("roomFile.txt"));
 ArrayList<String> str = new ArrayList<>();
 String line = "";
 while ((line=reader.readLine())!=null){
     str.add(line);
 }
 reader.close();
 Collections.sort(str);
 FileWriter writer = new FileWriter("roomFile.txt");
 for(String s: str){
     writer.write(s);
     writer.write("\r\n");
 }
 writer.close();

}
 else
{
    System.out.println("\n Enter a valid command please. type \"Java RMIClient\" to view command list\n");
}
 }

catch (Exception e){
    System.out.println("Recieved Exception: " + e.getMessage() );
}

    }
}

    






    

