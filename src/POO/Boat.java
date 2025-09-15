package POO;

public class Boat extends Prop{

    private float length;
    private boolean navigable;

    public Boat( String ID, String adress, String city, float length){
        super(ID, adress, city);
    }

    public float getLength() {
        return length;
    }

    public boolean isNavigable() {
        return navigable;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setNavigable(boolean navigable) {
        this.navigable = navigable;
    }
}
