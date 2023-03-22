package domashka;

public class Drinks extends Goods {
    private Double volume;

    public Drinks (String name, Double price, Integer amount, String unit, Double volume) {
        super(name, price, amount,unit);
        this.volume = volume;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
        .append(String.format("\tОбъем, л: %.1f;\n", volume)).toString();
    }

}