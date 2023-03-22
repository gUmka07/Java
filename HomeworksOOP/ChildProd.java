package domashka;

public class ChildProd extends Goods {

    Integer minimumAge;
    String hypoallergenic;

    public ChildProd (String name, Double price, Integer amount, String unit, Integer numberOfPack, Integer minimumAge, String hypoallergenic) {
        super (name, price, amount, unit);
        this.minimumAge = minimumAge;
        this. hypoallergenic = hypoallergenic;

    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
        .append(String.format("\tМинимальный возраст, мес.: %d;\n" + "\tГипоаллергенность: %s;\n", minAge, hypoallergenic)).toString();
    }

}