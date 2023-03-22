package domashka;

public class Food extends Goods {
    private String expirationDate;

    public Food (String name, Double price, Integer amount, String unit, String expirationDate ) {
        super(name, price, amount, unit);
        this.expirationDate = expirationDate;

    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
        .append(String.format("\tСрок годности: %s;\n", expirationDate)).toString();

    }
}
