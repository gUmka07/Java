public class Circle extends Shape{
    protected double radius;

    public Circle(double radius) throws Exception {
        this.radius = radius;
        if (radius <= 0){
            throw new Exception("Радиус должен быть больше 0!");
        }

    }

    @Override
    public double squareFigure() {
        return Math.PI * this.radius * this.radius;
    }

    public double circumference() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(String.format("\n\tДлина окружности, см: %.2f;\n", circumference())).toString();
    }
}