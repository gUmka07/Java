import model.Notepad;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

public class Program {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Notepad notepad = new Notepad();
        new Presenter(view, notepad);

        view.start();
    }
}
