public class Triangle extends Polygon {
    public Triangle(double sideA, double sideB, double sideC) throws Exception {
        super(sideA, sideB, sideC);
        this.sides.add(sideA);
        this.sides.add(sideB);
        this.sides.add(sideC);

        if (!((sideA + sideB) > sideC && (sideA + sideC) > sideB && (sideC + sideB) > sideA)) {
            throw new Exception("Треугольник с такими сторонами не может существовать.");
        }
    }

    @Override
    public double squareFigure() {
        double halfPerimeter = perimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - this.sides.get(0)) *
                (halfPerimeter - this.sides.get(1)) * (halfPerimeter - this.sides.get(2)));
    }
}