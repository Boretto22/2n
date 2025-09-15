package POO;

public class Owner {

    private String name;
    private String adress;
    private Prop[] props;
    private int numProps;

    public Owner(String name, String adress){

    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public Prop[] getProps() {
        return props;
    }

    public int getNumProps() {
        return numProps;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setProps(Prop[] props) {
        this.props = props;
    }

    public void setNumProps(int numProps) {
        this.numProps = numProps;

    }

    public void addProp(Prop p){
        if(numProps<props.length) {
            props[numProps] = p;
            numProps++;
        }
    }

    public float cheapestPrice(){

    }
}
