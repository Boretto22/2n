package POO;

public class MainProp {
    // Propietats estàtiques de la classe Main

    public static Owner[] allOwners;
    public static int numOwners;
    public static int numProps;

    public static void main(String[] args) {

        allOwners = new Owner[5];
        numOwners = 0;
        numProps = 0;

        House h1 = new House("H1", "C/Olesa", "Manacor", 5);
        House h2 = new House("H2", "31 de decembre", "Palma", 3);

        h1.setPrice(550000);
        h2.setPrice(700000);

        h1.setSwimmingpool(false);

        Boat b1 = new Boat("B1", "Moll 67", "Porto Cristo", 19.7f);
        Boat b2 = new Boat("B2", "Moll 13", "Palma", 19.7f);


        b1.setPrice(6000);
        b2.setPrice(5500);

        Owner p1 = new Owner("Tonio", "C/Olesa, Manacor");
        Owner p2 = new Owner("Bel", "31 de decembre, Palma");

        addOwner(p1);
        addOwner(p2);

        addProp("Tonio", h1);
        addProp("Tonio", b1);

        addProp("Bel", b2);
        addProp("Bel", h2);

        int numPalma = numPropsInCity(allOwners, "Palma");
        System.out.printf("%d props in %s. \n", numPalma, "Palma");

        String name = ownerCheapestProp(allOwners);
        System.out.printf("Owner cheapest prop: %s. \n", name);

        float extend = extendPrices(allOwners);
        System.out.printf("Extend prices: %f. \n", extend);

        int numBoats = numBoatsMinLength(3.0f, allOwners);
        System.out.printf("%d Boats larger than %f. \n", numBoats, 3.0f);

        int numPools = numHousesWithPool(allOwners);
        System.out.printf("%d Pools. \n", numPools);

    }

    public static void addOwner(Owner owner){
        if(numOwners<allOwners.length) {
            allOwners[numOwners] = owner;
            numOwners++;
        }
    }

    public static void addProp(String ownerName, Prop p){
        for(int i=0; i<numOwners; i++){
            Owner owner = allOwners[i];
            if(owner.getName().equals(ownerName)){
                owner.addProp(p);
                numProps++;
            }
        }
    }

    public static int numPropsInCity(Owner[] owners, String city){
        int n = 0;
        for(int i=0; i<owners.length; i++){
            Owner owner = owners[i];
            if(owner != null) {
                for (int j = 0; j < owner.getNumProps(); j++) {
                    Prop p = owner.getProps()[j];
                    if (p.getCity().equals(city)) {
                        n++;
                    }
                }
            }
        }
        return n;
    }

    public static String ownerCheapestProp(Owner[] owners){
        float minAllOwners = Float.MAX_VALUE;
        String ownerName = "";
        for(int i=0; i<owners.length; i++){
            Owner owner = owners[i];
            if(owner!=null) {
                float minOwner = owner.cheapestPrice();
                if (minOwner < minAllOwners) {
                    minAllOwners = minOwner;
                    ownerName = owner.getName();
                }
            }
        }
        return ownerName;
    }

    public static float extendPrices(Owner[] owners){
        float minPrice = Float.MAX_VALUE;
        float maxPrice = Float.MIN_VALUE;

        for(int i=0; i<owners.length; i++){
            Owner owner = owners[i];
            if(owner!=null) {

                float minOwner = owner.cheapestPrice();
                if (minOwner < minPrice) {
                    minPrice = minOwner;
                }

                float maxOwner = owner.expensivePrice();
                if (maxOwner > maxPrice) {
                    maxPrice = maxOwner;
                }
            }
        }
        return maxPrice - minPrice;
    }

    public static int numBoatsMinLength(float l, Owner[] owners){
        int n = 0;
        for(int i=0; i<owners.length; i++){
            Owner owner = owners[i];
            if(owner != null) {
                for (int j = 0; j < owner.getNumProps(); j++) {
                    Prop p = owner.getProps()[j];
                    if(p instanceof Boat) {
                        if (((Boat) p).getLength()>= l) {
                            n++;
                        }
                    }
                }
            }
        }
        return n;
    }

    public static int numHousesWithPool(Owner[] owners){
        int n = 0;
        for(int i=0; i<owners.length; i++){
            Owner owner = owners[i];
            if(owner != null) {
                for (int j = 0; j < owner.getNumProps(); j++) {
                    Prop p = owner.getProps()[j];
                    if(p instanceof House) {
                        if (((House) p).isSwimmingpool()) {
                            n++;
                        }
                    }
                }
            }
        }
        return n;
    }
}
