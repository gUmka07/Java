public class Main {
    public static void main(String[] args) throws Exception {
        Figures figures = new Figures();
        figures.addFigure(new Rectangle(2, 2));
        figures.addFigure(new Square(12));
        figures.addFigure(new Triangle(4, 2, 4));
        figures.addFigure(new Circle(23));
        figures.addFigure(new Circle(10));

        figures.showAll();
        System.out.println("_______________________________________________________\n");
        System.out.println("Удалим последнюю фигуру, заменим фигуру круг с радиусом 10 на " +
                "круг с радиусом 15, отсортируем фигуры по площади:");
        figures.removeFigure(2);
        figures.setFigure(4, new Circle(12));
        figures.sortBySquare();

        figures.showAll();

        figures.addFigure(new Circle(2));


    }
}
