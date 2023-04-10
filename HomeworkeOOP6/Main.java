import model.Notepad;
import presenter.Presenter;
import view.consoleUI.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Notepad notepad = new Notepad();
        new Presenter(view, notepad);

        view.start();
    }
}
