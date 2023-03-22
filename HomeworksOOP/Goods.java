// 1. Название
// 2. Цена
// 3. Количество
// 4. Единица измерения
package domashka;

public class Goods {

    protected  String name;
    protected  Double price;
    protected  Integer amount;
    protected  String unit;

    public Goods(String name, Double price, Integer amount, String unit) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format(new StringBuilder()
            .append("Название товара: %s;\n")
            .append("\tЦена товара, руб: %.2f;\n")
            .append("\tКоличесво: %d;\n")
            .append("\tЕдиница измерения: %s;\n").toString(), name, price, amount, unit);
    }
}