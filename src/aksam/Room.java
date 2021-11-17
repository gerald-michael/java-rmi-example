//package rooms;

import java.io.Serializable;
// Bean used to set and get data for a particular room object.
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private int type;
    private String price;
    private int available;
    public Room(int type, String price) {
        this.type=type;
        this.price=price;
    }
    public  Room(int type, String price, int available){
        this.type=type;
        this.price=price;
        this.available=available;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type){
        this.type=type;

    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(int price){

    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
