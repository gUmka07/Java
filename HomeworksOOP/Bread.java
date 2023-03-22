package domashka;

public class Bread extends Food {

    String flour;

    public Bread (String name, Double price, Integer amount, String unit, String expirationDate, String flour) {
        super(name, price, amount, unit, expirationDate);
        this.flour = flour;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
        .append(String.format("\tТип хлеба: %s;\n", typeBread)).toString();
    }

}
