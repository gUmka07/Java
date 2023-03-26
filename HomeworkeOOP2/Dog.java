public class Dog extends Pets implements MakesSound, ShowAffection, Training {
    private String haveTraining;

    public Dog(double growth, double weight, String eyeColor, String name, String breed,
               String vaccination, String woolColor, String dataBirth, String haveTraining) {
        super(growth, weight, eyeColor, name, breed, vaccination, woolColor, dataBirth);
        this.haveTraining = haveTraining;
    }

    public String getHaveTraining() {
        return haveTraining;
    }

    @Override
    public void training() {
        System.out.println("Проходит дрессировку");
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\tНаличие дрессировки: %s;\n", haveTraining)).toString();
    }

    @Override
    public void makesSound() {
        System.out.println("Гав-Гав");
    }

    @Override
    public void showAffection() {
        System.out.println("Проявляет ласку, когда чешут пузико! ");
    }
}