package domashka;

public class ToiletPaper extends HygieneItems {
    Integer numberLayers;

    public ToiletPaper (String name, Double price, Integer amount, String unit, Integer numberOfPack, Integer numberLayers) {
        super(name, price, amount, unit, numberOfPack);
        this.numberLayers = numberLayers;

    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tКоличество слоев: %d;\n", numberLayers)).toString();
}