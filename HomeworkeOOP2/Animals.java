public abstract class Animals {
    protected double Growth;
    protected double Weight;
    protected String EyeColor;

    public Animals(double Growth, double Weight, String EyeColor) {
        this.Growth = Growth;
        this.Weight = Weight;
        this.EyeColor = EyeColor;
    }

    public abstract void makesSound();
    @Override
    public String toString() {
        return String.format(new StringBuilder().append("\tРост, см: %.2f;\n")
                .append("\tВес, кг: %.2f;\n")
                .append("\tЦвет глаз: %s;\n").toString(), Growth, Weight, EyeColor);
    }
}
