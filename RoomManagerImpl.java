
import java.io.FileInputStream;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Iterator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {
        // Creating an empty HashMap 
        HashMap<Integer, String>hashMapOfType0 = new HashMap<>();
                       
        int count;
    
        // Default constructor to throw RemoteException
	// from its parent constructor
	public RoomManagerImpl() throws RemoteException 
        { 
            super(); 
        }
    
//    @Override
//    public int list(HashMap roomType) throws RemoteException 
//    {
//        int counts = Collections.frequency(roomType.values(), "NA");
//        return counts;
//    }
      
      @Override
      public void initialize() throws RemoteException
      {
        
          HashMap<Integer, String> hashMapOfType0 = new HashMap<>();
          HashMap<Integer, String> hashMapOfType1 = new HashMap<>();
          HashMap<Integer, String> hashMapOfType2 = new HashMap<>();
          HashMap<Integer, String> hashMapOfType3 = new HashMap<>();
          HashMap<Integer, String> hashMapOfType4 = new HashMap<>();
        
          
                        // Initializing Type0 Room HashMap
                        for(int room = 1; room < 11; room++)
                        {
                            hashMapOfType0.put(room, "NA");
                        }
                                                                      
                        // Initializing Type1 Room HashMap
                        for(int room = 1; room < 21; room++)
                        {
                            hashMapOfType1.put(room, "NA");
                        }                      
                        
                        // Initializing Type2 Room HashMap
                        for(int room = 1; room < 6; room++)
                        {
                            hashMapOfType2.put(room, "NA");
                        }
                                                
                        // Initializing Type3 Room HashMap
                        for(int room = 1; room < 4; room++)
                        {
                            hashMapOfType3.put(room, "NA");
                        }
                                                
                        // Initializing Type4 Room HashMap
                        for(int room = 1; room < 3; room++)
                        {
                            hashMapOfType4.put(room, "NA");
                        }
                                
                        // Serializing the HashMap Objects
                        try 
                        {
                            FileOutputStream myFileOutStream0 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap0.txt");

                            ObjectOutputStream myObjectOutStream0 = new ObjectOutputStream(myFileOutStream0);

                            myObjectOutStream0.writeObject(hashMapOfType0);

                            myObjectOutStream0.close();
                            myFileOutStream0.close();
                        
                        }
                        catch (IOException e) 
                        {
                            
                        }
                        
                        try 
                        {
                        
                            FileOutputStream myFileOutStream1 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap1.txt");

                            ObjectOutputStream myObjectOutStream1 = new ObjectOutputStream(myFileOutStream1);

                            myObjectOutStream1.writeObject(hashMapOfType1);

                            myObjectOutStream1.close();
                            myFileOutStream1.close();
                        }
                        catch (IOException e)
                        {
                            
                        }
                        
                        try 
                        {
                        
                            FileOutputStream myFileOutStream2 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap2.txt");

                            ObjectOutputStream myObjectOutStream2 = new ObjectOutputStream(myFileOutStream2);

                            myObjectOutStream2.writeObject(hashMapOfType2);

                            myObjectOutStream2.close();
                            myFileOutStream2.close();
                        }
                        catch (IOException e)
                        {
                            
                        }
                        
                        
                        try 
                        {
                        
                            FileOutputStream myFileOutStream3 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap3.txt");

                            ObjectOutputStream myObjectOutStream3 = new ObjectOutputStream(myFileOutStream3);

                            myObjectOutStream3.writeObject(hashMapOfType3);

                            myObjectOutStream3.close();
                            myFileOutStream3.close();
                        }
                        catch (IOException e)
                        {
                            
                        }
                        
                        
                        try 
                        {
                            FileOutputStream myFileOutStream4 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap4.txt");

                            ObjectOutputStream myObjectOutStream4 = new ObjectOutputStream(myFileOutStream4);

                            myObjectOutStream4.writeObject(hashMapOfType4);

                            myObjectOutStream4.close();
                            myFileOutStream4.close();
                        }
                        catch (IOException e)
                        {
                            
                        }
      }
      

    @Override
    public int book(int roomType, String guestName) throws RemoteException, IOException 
    {   
        int key = 0;
        switch (roomType) 
            {
                case 0:
                    
                    HashMap<Integer, String> newHashMap0 = null;                    
                    try {
                        FileInputStream fileInput0 = new FileInputStream("/home/house/Downloads/Javame/newHashMap0.txt");
                        
                        ObjectInputStream objectInput0 = new ObjectInputStream(fileInput0);
                        
                        newHashMap0 = (HashMap)objectInput0.readObject();
                        
                        Iterator it = newHashMap0.entrySet().iterator();
                        objectInput0.close();
                        fileInput0.close();
                        
                        for (Entry<Integer, String> entry : newHashMap0.entrySet()) 
                        {
                            if (entry.getValue().equals("NA")) 
                            {
                                key = entry.getKey();
                                newHashMap0.put(key, guestName);
                                
                                break;
                            }
                            else
                            {
                               key = -1;
                                break;
                            }
                        }
                        
                        
                        FileOutputStream myFileOutStream0 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap0.txt");
                        
                        ObjectOutputStream myObjectOutStream0 = new ObjectOutputStream(myFileOutStream0);
                        
                        myObjectOutStream0.writeObject(newHashMap0);
                        
                        myObjectOutStream0.close();
                        myFileOutStream0.close();
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    return key;

                
                case 1:
                    HashMap<Integer, String> newHashMap1 = null;
                    
                    try {
                        FileInputStream fileInput1 = new FileInputStream("/home/house/Downloads/Javame/newHashMap1.txt");
                        
                        ObjectInputStream objectInput1  = new ObjectInputStream(fileInput1);
                        
                        newHashMap1 = (HashMap)objectInput1.readObject();
                        
                        Iterator it = newHashMap1.entrySet().iterator();
                        objectInput1.close();
                        fileInput1.close();
                        
                        for (Entry<Integer, String> entry : newHashMap1.entrySet()) 
                        {
                            if (entry.getValue().equals("NA")) 
                            {
                                key = entry.getKey();
                                newHashMap1.put(key, guestName);
                                
                                break;
                            }
                             else
                            {
                                key = -1;
                                break;
                            }
                        }
                        
                        
                        FileOutputStream myFileOutStream1 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap1.txt");
                        
                        ObjectOutputStream myObjectOutStream1 = new ObjectOutputStream(myFileOutStream1);
                        
                        myObjectOutStream1.writeObject(newHashMap1);
                        
                        myObjectOutStream1.close();
                        myFileOutStream1.close();

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    return key;
                    
                case 2:
                    HashMap<Integer, String> newHashMap2 = null;
                    
                    try {
                        FileInputStream fileInput2 = new FileInputStream("/home/house/Downloads/Javame/newHashMap2.txt");
                        
                        ObjectInputStream objectInput2 = new ObjectInputStream(fileInput2);
                        
                        newHashMap2 = (HashMap)objectInput2.readObject();
                        
                        Iterator it = newHashMap2.entrySet().iterator();
                        objectInput2.close();
                        fileInput2.close();
                        
                        for (Entry<Integer, String> entry : newHashMap2.entrySet()) 
                        {
                            if (entry.getValue().equals("NA")) 
                            {
                                key = entry.getKey();
                                newHashMap2.put(key, guestName);
                                
                                break;
                            }
                             else
                            {
                                key = -1;
                                break;
                            }
                        }
                        
                        
                        FileOutputStream myFileOutStream2 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap2.txt");
                        
                        ObjectOutputStream myObjectOutStream2 = new ObjectOutputStream(myFileOutStream2);
                        
                        myObjectOutStream2.writeObject(newHashMap2);
                        
                        myObjectOutStream2.close();
                        myFileOutStream2.close();


                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    return key;
                    
                case 3:
                    HashMap<Integer, String> newHashMap3 = null;
                    
                    try {
                        FileInputStream fileInput3 = new FileInputStream("/home/house/Downloads/Javame/newHashMap3.txt");
                        
                        ObjectInputStream objectInput3 = new ObjectInputStream(fileInput3);
                        
                        newHashMap3 = (HashMap)objectInput3.readObject();
                        
                        Iterator it = newHashMap3.entrySet().iterator();
                        objectInput3.close();
                        fileInput3.close();
                        
                        for (Entry<Integer, String> entry : newHashMap3.entrySet()) 
                        {
                            if (entry.getValue().equals("NA")) 
                            {
                                key = entry.getKey();
                                newHashMap3.put(key, guestName);
                                
                                break;
                            }
                             else
                            {
                                key = -1;
                                break;
                            }
                        }
                        
                        
                        FileOutputStream myFileOutStream3 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap3.txt");
                        
                        ObjectOutputStream myObjectOutStream3 = new ObjectOutputStream(myFileOutStream3);
                        
                        myObjectOutStream3.writeObject(newHashMap3);
                       
                        myObjectOutStream3.close();
                        myFileOutStream3.close();
                       
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    return key;

                case 4:
                    HashMap<Integer, String> newHashMap4 = null;
                    
                    try {
                        FileInputStream fileInput4 = new FileInputStream("/home/house/Downloads/Javame/newHashMap4.txt");
                        
                        ObjectInputStream objectInput4 = new ObjectInputStream(fileInput4);
                        
                        newHashMap4 = (HashMap)objectInput4.readObject();
                        
                        Iterator it = newHashMap4.entrySet().iterator();
                        objectInput4.close();
                        fileInput4.close();
                        
                        for (Entry<Integer, String> entry : newHashMap4.entrySet()) 
                        {
                            if (entry.getValue().equals("NA")) 
                            {
                                key = entry.getKey();
                                newHashMap4.put(key, guestName);
                               
                                break;
                            }
                             else
                            {
                                key = -1;
                                break;
                            }
                        }
                        
                        
                        FileOutputStream myFileOutStream4 = new FileOutputStream("/home/house/Downloads/Javame/newHashMap4.txt");
                        
                        ObjectOutputStream myObjectOutStream4 = new ObjectOutputStream(myFileOutStream4);
                        
                        myObjectOutStream4.writeObject(newHashMap4);
                        
                        myObjectOutStream4.close();
                        myFileOutStream4.close();
 
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    return key;
                    
                default:
                    return key;
            }
    }
    
    @Override
    public List guests() throws RemoteException 
    {
        
        HashMap<Integer, String> newHashMap0 = null;
        HashMap<Integer, String> newHashMap1 = null;
        HashMap<Integer, String> newHashMap2 = null;
        HashMap<Integer, String> newHashMap3 = null;
        HashMap<Integer, String> newHashMap4 = null;
        
        List list0 = new ArrayList();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        List list4 = new ArrayList();
        List listAll = new ArrayList();

		try {
			FileInputStream fileInput0 = new FileInputStream("/home/house/Downloads/Javame/newHashMap0.txt");

			ObjectInputStream objectInput0 = new ObjectInputStream(fileInput0);

			newHashMap0 = (HashMap)objectInput0.readObject();
                        
                        objectInput0.close();
                        fileInput0.close();
        
                        for (Entry<Integer, String> entry : newHashMap0.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                list0.add(entry.getValue()); 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                try {
			FileInputStream fileInput1 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap1.txt");

			ObjectInputStream objectInput1
				= new ObjectInputStream(fileInput1);

			newHashMap1 = (HashMap)objectInput1.readObject();
                        
                        objectInput1.close();
                        fileInput1.close();
        
                        for (Entry<Integer, String> entry : newHashMap1.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                list1.add(entry.getValue()); 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                try {
			FileInputStream fileInput2 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap2.txt");

			ObjectInputStream objectInput2
				= new ObjectInputStream(fileInput2);

			newHashMap2 = (HashMap)objectInput2.readObject();
                        
                        objectInput2.close();
                        fileInput2.close();
        
                        for (Entry<Integer, String> entry : newHashMap2.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                list2.add(entry.getValue()); 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                try {
			FileInputStream fileInput3 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap3.txt");

			ObjectInputStream objectInput3
				= new ObjectInputStream(fileInput3);

			newHashMap3 = (HashMap)objectInput3.readObject();
                        
                        objectInput3.close();
                        fileInput3.close();
        
                        for (Entry<Integer, String> entry : newHashMap3.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                list3.add(entry.getValue()); 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                try {
			FileInputStream fileInput4 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap4.txt");

			ObjectInputStream objectInput4
				= new ObjectInputStream(fileInput4);

			newHashMap4 = (HashMap)objectInput4.readObject();
                        
                        objectInput4.close();
                        fileInput4.close();
        
                        for (Entry<Integer, String> entry : newHashMap4.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                list4.add(entry.getValue()); 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }



                    list1.addAll(list0);
                    list2.addAll(list1);
                    list3.addAll(list2);
                    list4.addAll(list3);
                    listAll.addAll(list4);

                return listAll;
        }
        
    

    @Override
    public int[] revenue() throws RemoteException {
        
        
        HashMap<Integer, String> newHashMap0 = null;
        HashMap<Integer, String> newHashMap1 = null;
        HashMap<Integer, String> newHashMap2 = null;
        HashMap<Integer, String> newHashMap3 = null;
        HashMap<Integer, String> newHashMap4 = null;
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        
        int revenueAll[] = new int[5];
        
        try {
			FileInputStream fileInput0 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap0.txt");

			ObjectInputStream objectInput0
				= new ObjectInputStream(fileInput0);

			newHashMap0 = (HashMap)objectInput0.readObject();
                        
                        objectInput0.close();
                        fileInput0.close();
        
                        for (Entry<Integer, String> entry : newHashMap0.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                counter0++; 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                try {
			FileInputStream fileInput1 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap1.txt");

			ObjectInputStream objectInput1
				= new ObjectInputStream(fileInput1);

			newHashMap1 = (HashMap)objectInput1.readObject();
                        
                        objectInput1.close();
                        fileInput1.close();
        
                        for (Entry<Integer, String> entry : newHashMap1.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                counter1++; 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                try {
			FileInputStream fileInput2 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap2.txt");

			ObjectInputStream objectInput2
				= new ObjectInputStream(fileInput2);

			newHashMap2 = (HashMap)objectInput2.readObject();
                        
                        objectInput2.close();
                        fileInput2.close();
        
                        for (Entry<Integer, String> entry : newHashMap2.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                counter2++; 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                try {
			FileInputStream fileInput3 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap3.txt");

			ObjectInputStream objectInput3
				= new ObjectInputStream(fileInput3);

			newHashMap3 = (HashMap)objectInput3.readObject();
                        
                        objectInput3.close();
                        fileInput3.close();
        
                        for (Entry<Integer, String> entry : newHashMap3.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                counter3++; 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                try {
			FileInputStream fileInput4 = new FileInputStream(
				"/home/house/Downloads/Javame/newHashMap4.txt");

			ObjectInputStream objectInput4
				= new ObjectInputStream(fileInput4);

			newHashMap4 = (HashMap)objectInput4.readObject();
                        
                        objectInput4.close();
                        fileInput4.close();
        
                        for (Entry<Integer, String> entry : newHashMap4.entrySet()) 
                        {
                            if (!entry.getValue().equals("NA")) 
                            { 
                                counter4++; 
                            }
                           
                        }
                } 
               
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(RoomManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                
                revenueAll[0] = counter0;
                revenueAll[1] = counter1;
                revenueAll[2] = counter2;
                revenueAll[3] = counter3;
                revenueAll[4] = counter4;
                
        return revenueAll;
    }

   
}
    
