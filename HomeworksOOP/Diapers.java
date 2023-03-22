package domashka;

public class Diapers extends ChildProd {

    String size;
    Integer minWeight;
    Integer maxWeight;
    String type;

    public Diapers (String name, Double price, Integer amount, String unit, Integer numberOfPack, Integer minimumAge, String hypoallergenic, String size, Integer maxWeight, Integer maxWeight, String type) {
        super(name, price, amount, unit, numberOfPack, minimumAge, hypoallergenic);
        this.size = size;
        this.minWeight = maxWeight;
        this.maxWeight = maxWeight;
        this.type = type;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
        .append(String.format("\tРазмер: %s;\n\tМин. вес: %d кг;\n" + "\tМакс. вес: %d кг;\n", size, minWeight, maxWeight)).toString();
    }
}