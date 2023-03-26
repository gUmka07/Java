public class Stork extends Birds implements MakesSound, Fly{
    protected Stork(double Growth, double Weight, String EyeColor) {
        super(Growth, Weight, EyeColor, 2500.0, null);
    }

    @Override
    public void makesSound() {
        System.out.println("Делаю клювом тук-тук и приношу детей");
    }

    @Override
    public void fly() {
        System.out.printf("Я лечу на высоте %.2f метров!", getFlightAltitude());
    }
}