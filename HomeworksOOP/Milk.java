package domashka;

public class Milk extends Food {

    Integer fatContent;
    Double volume;

    public Milk (String name, Double price, Integer amount, String unit, String expirationDate, Integer fatContent, Double volume) {
        super(name, price, amount, unit, expirationDate);
        this.fatContent = fatContent;
        this.volume = volume;
        
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tЖирность, %%: %.1f;\n" +
                        "\tОбъем, л: %.1f;\n", fatContent, volume)).toString();
}