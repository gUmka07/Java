public abstract class Pets extends Animals{
    
    protected String name;
    protected String breed;
    protected String vaccination;
    protected String woolColor;
    protected String dataBirth;

    public Pets (Double Height, double weight, String EyeColor, String name, String breed, String vaccination, String woolColor, String dataBirth) {
    super(Height,weight,EyeColor);

    this.name = name;
    this.breed = breed; 
    this.vaccination = vaccination;
    this.woolColor = woolColor;
    this.dataBirth = dataBirth;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tКличка: %s;\n" +
                        "\tПорода: %s;\n\tПрививки: %s;\n\tЦвет шерсти: %s;\n" +
                        "\tДата рождения: %s;\n", name, breed, vaccination,
                        woolColor,dataBirth)).toString();
    }
}
