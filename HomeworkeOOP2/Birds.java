public abstract class Birds extends Animals {
    private double flightAltitude;
    public Birds(Double Height, double Weight, String EyeColor, Double FlightAltitude, Birds birds) {
        super(Height, Weight, EyeColor);
        this.Weight = Weight;
        this.EyeColor = EyeColor;
    }

    @Override 
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tВысота полета, метр: %.2f;\n", flightAltitude)).toString();
    }

    public double getFlightAltitude() {
        return flightAltitude;
    }

}

