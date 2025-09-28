package POO;

public class Owner {

    private String name;
    private String adress;
    private Prop[] props;
    private int numProps;

    public Owner(String name, String adress){
        this.name = name;
        this.adress = adress;
        this.props = new Prop[5];
        this.numProps = 0;
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
        float min = Float.MAX_VALUE;
        for(int i=0; i<this.numProps; i++){
            Prop pi = this.props[i];
            if(pi.getPrice()< min){
                min = pi.getPrice();
            }
        }
        return min;
    }

    public float expensivePrice(){
        float max = Float.MIN_VALUE;
        for(int i=0; i<this.numProps; i++){
            Prop pi = this.props[i];
            if(pi.getPrice()> max){
                max = pi.getPrice();
            }
        }
        return max;
    }

    public float averagePrices(){
        float sum = 0.0f;
        for(int i=0; i<this.numProps; i++){
            Prop pi = this.props[i];
            sum += pi.getPrice();
        }
        return sum / this.numProps;
    }

    public Prop cheapestProp(){
        float min = Float.MAX_VALUE;
        Prop minProp = null;
        for(int i=0; i<this.numProps; i++){
            Prop pi = this.props[i];
            if(pi.getPrice()< min){
                min = pi.getPrice();
                minProp = pi;
            }
        }
        return minProp;
    }

    public void sortPropsByPrice(){
        boolean sorted = false;
        while(!sorted){
            sorted =true;
            for(int i=0; i<this.numProps-1; i++){
                Prop p1 = this.props[i];
                Prop p2 = this.props[i+1];
                if(p1.getPrice() > p2.getPrice()){
                    Prop pTemp = p1;
                    p1 = p2;
                    p2 = pTemp;
                    sorted = false;
                }
            }
        }
    }
}
