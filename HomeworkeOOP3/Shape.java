public abstract class Shape implements Comparable <Shape> {
    public abstract double squareFigure();

    @Override
    public String toString() {
        return String.format(new StringBuilder().append(this.getClass().getSimpleName())
                .append("\n\tПлощадь, см^2: %.2f;").toString(), squareFigure());
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(this.squareFigure(), o.squareFigure());
    }
}

