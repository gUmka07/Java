public abstract class WildAnimal extends Animals implements MakesSound{
    protected String habitat;
    protected String dataBirth;

    public WildAnimal(double growth, double weight, String eyeColor, String habitat, String dataBirth) {
        super(growth, weight, eyeColor);
        this.habitat = habitat;
        this.dataBirth = dataBirth;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tСреда обитания: %s;\n" +
                                "\tДата рождения: %s;\n", habitat,dataBirth)).toString();
    }
}