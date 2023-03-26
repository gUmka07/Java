public class Chicken extends Birds implements MakesSound, Fly{
    protected Chicken(double growth, double weight, String eyeColor) {
        super(growth, weight, eyeColor, 0.0, null);
    }

    @Override
    public void makesSound() {
        System.out.println("Ко Ко Ко");
    }

    @Override
    public void fly() {
        System.out.println("Я не умею летать, но бегаю быстро");
    }
}