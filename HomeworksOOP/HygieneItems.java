package domashka;

public class HygieneItems extends Goods {

    Integer numberOfPack;

    public HygieneItems (String name, Double price, Integer amount, String unit, Integer numberOfPack) {
        super (name, price, amount, unit);
        this.numberOfPack = numberOfPack;

    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tКоличество штук в упаковке: %d;\n", numberOfPack)).toString();
}