public class Cat extends Pets implements MakesSound, ShowAffection {
    private String haveWool;

    public Cat(double growth, double weight, String eyeColor, String name, String breed,
               String vaccination, String woolColor, String dataBirth, String haveWool) {
        super(growth, weight, eyeColor, name, breed, vaccination, woolColor, dataBirth);
        this.haveWool = haveWool;
    }

    public String getHaveWool() {
        return haveWool;
    }

    @Override
    public void makesSound() {
        System.out.println("Мяу");
    }

    @Override
    public void showAffection() {
        System.out.println("Проявляет ласку, когда хочет есть");
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tНаличие шерсти: %s;\n", haveWool)).toString();
    }
}