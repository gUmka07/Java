package domashka;

public class Eggs extends Food {

    Integer numberOfPack;

    public Eggs (String name, Double price, Integer amount, String unit, String expirationDate, Integer numberOfPack) {
        super(name, price, amount, unit, expirationDate);
        this.numberOfPack = numberOfPack;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
        .append(String.format("\tКоличество шт. в упаковке: %d;\n", numberOfPack)).toString();
    }
}