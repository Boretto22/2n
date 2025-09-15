package POO;

public class Prop {

    private String propID;
    private String adress;
    private String city;
    private float price;

    public Prop(String ID, String adress, String city){
    }

    public String getPropID() {
        return propID;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public float getPrice() {
        return price;
    }

    public void setPropID(String propID) {
        this.propID = propID;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isCheaperTha (Prop p){
        return price < p.price;
    }

    public boolean sameCity (Prop p){
        return city == p.city;
    }
}
