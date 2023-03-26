public class Wolf extends WildAnimal{
    private String leader;

    public Wolf(double growth, double weight, String eyeColor, String habitat,
                String dataBirth, String leader) {
        super(growth, weight, eyeColor, habitat, dataBirth);
        this.leader = leader;
    }

    public String getLeader() {
        return leader;
    }

    @Override
    public void makesSound() {
        System.out.println("Уyyyyyyyyy");
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tВожак стаи: %s;\n", leader)).toString();
    }
}