package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class HotelClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {

        HotelClientImpl client = new HotelClientImpl();
        client.startClient();
        if (args.length == 0) {
            System.out.println("Usage: ");
            return;
        }
        if (args[0].equals("list")) {
            System.out.println("List: ");
            HashMap<shared.Type, Integer> list = client.list();
            System.out.println(list.get(shared.Type.TYPE0) + " rooms of type 0 are available for 55,000 UGX per night");
            System.out.println(list.get(shared.Type.TYPE1) + " rooms of type 1 are available for 75,000 UGX per night");
            System.out.println(list.get(shared.Type.TYPE2) + " rooms of type 2 are available for 80,000 UGX per night");
            System.out
                    .println(list.get(shared.Type.TYPE3) + " rooms of type 3 are available for 150,000 UGX per night");
            System.out
                    .println(list.get(shared.Type.TYPE4) + " rooms of type 4 are available for 230,000 UGX per night");
        }

        if (args[0].equals("book")) {
            try {
                int type;
                boolean result;
                try {
                    type = Integer.parseInt(args[1]);
                    String name = args[2];
                    switch (type) {
                    case 0:
                        result = client.book(name, shared.Type.TYPE0);
                        break;
                    case 1:
                        result = client.book(name, shared.Type.TYPE1);
                        break;
                    case 2:
                        result = client.book(name, shared.Type.TYPE2);
                        break;
                    case 3:
                        result = client.book(name, shared.Type.TYPE3);
                        break;
                    case 4:
                        result = client.book(name, shared.Type.TYPE4);
                        break;
                    default:
                        System.out.println("type must be one of 0,1,2,3,4");
                        result = false;
                        break;
                    }
                    if (result) {
                        System.out.println("Room booked successfully.");
                    }
                } catch (NumberFormatException n) {
                    System.out.println("type must be one of 0,1,2,3,4");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Type and name required.");
            }
        }

        if (args[0].equals("guests")) {
            ArrayList<String> guests = client.guests();
            System.out.println("Guests: ");
            guests.forEach(guest -> System.out.println(guest));
        }

        if (args[0].equals("revenue")) {
            System.out.println("Revenue: " + client.revenue());
        }
    }
}
