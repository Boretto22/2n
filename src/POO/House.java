package POO;

public class House extends Prop {

    private int numRooms;
    private boolean swimmingpool;

    public House(String ID, String adress, String city, int numRooms){
        super(ID, adress, city);

    }

    public int getNumRooms() {
        return numRooms;
    }

    public boolean isSwimmingpool() {
        return swimmingpool;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public void setSwimmingpool(boolean swimmingpool) {
        this.swimmingpool = swimmingpool;
    }
}
