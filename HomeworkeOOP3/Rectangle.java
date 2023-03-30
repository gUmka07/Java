public class Rectangle extends Polygon{
    public Rectangle(double sideA, double sideB) throws Exception {
        super(sideA, sideB);
        this.sides.add(sideA);
        this.sides.add(sideB);
        this.sides.add(sideA);
        this.sides.add(sideB);

        if (!(sideA < (sideA + 2 * sideB) && sideB < (sideB + 2 * sideA))){
            throw new Exception("Прямоугольник с такими сторонами не может существовать.");
        }
    }

    @Override
    public double squareFigure() {
        return this.sides.get(0)* this.sides.get(1);
    }
}