package view;

import presenter.Presenter;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View {
    Scanner scanner;
    Presenter presenter;
    ArrayList<String> infoMessages = new ArrayList<>();

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        //noinspection StatementWithEmptyBody
        while (startMenu()) ;
        if(presenter.isOpened()){
            //noinspection StatementWithEmptyBody
            while (workWithFileMenu()) ;
        }
    }

    public void print(String text) {
        System.out.print(text);
    }

    private boolean startMenu() {
        clearConsole();
        showInfoMessages();

        print("=====Стартовое меню=====\n");
        print("\t1. Создать файл\n");
        print("\t2. Открыть файл\n");
        print("\t0. Выйти\n");

        String choice = this.getCommand();

        switch (choice) {
            case "1" -> {
                //noinspection StatementWithEmptyBody
                while (createFileMenu()) ;
            }
            case "2" -> {
                //noinspection StatementWithEmptyBody
                while (openFileMenu()) ;
            }
            case "0" -> {
                return false;
            }
            default -> this.infoMessages.add("ОШИБКА: Команда не распознана.");
        }
        return !this.presenter.isOpened();
    }

    private boolean createFileMenu() {
        clearConsole();
        showInfoMessages();

        print("=====Меню создания файла=====\n");
        print("Введите имя для нового файла (для отмены введите 0) >: ");

        String fileName = this.getCommand();

        if (fileName.equals("0")) {
            return false;
        } else {
            try {
                this.presenter.createFile(fileName);
                this.infoMessages.add(String.format("Файл \"%s.txt\" успешно создан!", fileName));
                this.presenter.openFile(fileName);
                return false;
            } catch (Exception e) {
                this.infoMessages.add(e.getMessage());
            }
        }
        return true;
    }

    private boolean openFileMenu() {
        clearConsole();
        showInfoMessages();
        ArrayList<String> filesNames = this.presenter.getAllFilesNames();
        int choice = flipMenu("=====Меню выбора файла=====\nВыберите файл:", filesNames);
        try {
            if (choice != -1) {
                this.presenter.openFile(filesNames.get(choice));
                this.infoMessages.add(String.format("Файл \"%s\" успешно открыт!", choice));
            }
            return false;
        } catch (Exception e) {
            this.infoMessages.add(e.getMessage());
        }
        return true;
    }

    private boolean workWithFileMenu() {
        clearConsole();
        showInfoMessages();
        String fileName = "N/A";

        try {
            fileName = this.presenter.getFileName();
        } catch (Exception e) {
            this.infoMessages.add(e.getMessage());
        }

        print(String.format("=====Меню работы с файлом \"%s\"=====\n", fileName));
        print("\t1. Показать все записи\n");
        print("\t2. Показать последнюю запись\n");
        print("\t3. Добавить запись\n");
        if (this.presenter.isUnsaved()) print("\t9. Сохранить изменения\n");
        print("\t0. Выйти\n");

        if (this.presenter.isUnsaved()) print("\n[изменения не сохранены]");


        String choice = this.getCommand();

        switch (choice) {
            case "1" -> {
                //noinspection StatementWithEmptyBody
                while (allNotesMenu()) ;
            }
            case "2" -> {
                try {
                    noteMenu(this.presenter.getContent().size() - 1);
                } catch (Exception e) {
                    infoMessages.add("Список записей пуст, невозможно получить последнюю запись.");
                }
            }
            case "3" -> {
                this.presenter.addNote(getNewNote());
                infoMessages.add("Запись добавлена!");
            }
            case "9" -> {
                if (this.presenter.isUnsaved()) {
                    try {
                        this.presenter.saveChanges();
                        this.infoMessages.add("Файл успешно сохранён!");
                    } catch (Exception e) {
                        this.infoMessages.add(e.getMessage());
                    }
                } else {
                    this.infoMessages.add("ОШИБКА: Команда не распознана.");
                }
            }
            case "0" -> {
                return exit();
            }
            default -> this.infoMessages.add("ОШИБКА: Команда не распознана.");
        }
        return true;
    }

    private boolean allNotesMenu() {
        try {
            ArrayList<String> notes = this.presenter.getContent();

            if (notes.isEmpty()) {
                this.infoMessages.add("Список записей пуст.\n");
            } else {
                int choice = this.flipMenu("=====Все заметки=====\nВыберите заметку:", notes);
                if (choice != -1) {
                    //noinspection StatementWithEmptyBody
                    while (noteMenu(choice)) ;
                } else {
                    return false;
                }
            }
            if (notes.isEmpty()) return false;
        } catch (Exception e) {
            this.infoMessages.add(e.getMessage());
        }
        return true;
    }

    private boolean noteMenu(int index) {
        try {
            String noteText = this.presenter.getContent().get(index);
            this.infoMessages.add(noteText + "\n");
            clearConsole();
            showInfoMessages();
            print(String.format("=====Меню работы с записью #%d=====\n", index + 1));
            print("\t1. Изменить запись\n");
            print("\t2. Удалить запись\n");
            print("\t0. Назад\n");

            String choice = this.getCommand();

            switch (choice) {
                case "1" -> {
                    this.presenter.replaceNote(index, getNewNote());
                    this.infoMessages.add("Запись изменена!\n");
                }
                case "2" -> {
                    this.presenter.removeNote(index);
                    this.infoMessages.add("Запись удалена!\n");
                    return false;
                }
                case "0" -> {
                    return false;
                }
            }
        } catch (Exception e) {
            this.infoMessages.add(e.getMessage());
        }
        return true;
    }

    private int flipMenu(String title, ArrayList<String> list) {
        int currentPage = 0;
        int menuSize = 7;

        while (true) {
            clearConsole();
            showInfoMessages();

            // Показываем заголовок
            print(title + "\n");

            // Показываем все элементы списка на конкретной странице
            for (int i = currentPage * menuSize; i < (currentPage + 1) * menuSize && i < list.size(); i++) {
                // Укорачиваем запись чтобы она не была слишком длинной
                String string = list.get(i);
                if (string.length() > 50) {
                    string = string.substring(0, 50) + "<...>";
                }
                // Выводим запись с порядковым номером меню
                print(String.format("\t%d. %s\n", (i - currentPage * menuSize) + 1, string));
            }

            // Показываем пункт меню "Предыдущая страница" если есть куда листать.
            if (currentPage > 0) print(String.format("\t%d. <<< Предыдущая страница\n", menuSize + 1));
            // Показываем пункт меню "Следующая страница" если есть куда листать.
            if (currentPage * menuSize + menuSize < list.size())
                print(String.format("\t%d. Следующая страница >>>\n", menuSize + 2));
            print("\t0. Назад\n");
            // Показываем номер текущей страницы и общее количество страниц, если есть куда листать.
            if (list.size() > menuSize) {
                print(String.format("[Страница %d/%d]\n", currentPage + 1, list.size() / menuSize));
            }

            String choice = this.getCommand();

            switch (choice) {
                case "1", "2", "3", "4", "5", "6", "7" -> {
                    return currentPage * menuSize + Integer.parseInt(choice) - 1;
                }
                case "8" -> {
                    if (currentPage > 0) currentPage -= 1;
                }
                case "9" -> {
                    if (currentPage + menuSize < list.size()) currentPage += 1;
                }
                case "0" -> {
                    return -1;
                }
                default -> this.infoMessages.add("ОШИБКА: Команда не распознана.");
            }
        }
    }

    private String getCommand() {
        this.print("\nВведите команду >: ");
        return this.scanner.nextLine();
    }

    private String getNewNote() {
        print("Введите текст записи, для отмены оставьте ввод пустым\n");
        print(">: ");
        return this.scanner.nextLine();
    }

    private void clearConsole() {
        this.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private void showInfoMessages() {
        if (!this.infoMessages.isEmpty()) {
            for (String message : infoMessages) {
                this.print(message + "\n");
            }
            this.infoMessages.clear();
        }
    }

    private boolean exit() {
        if (!this.presenter.isUnsaved()) {
            return false;
        } else {
            while (true){
                clearConsole();
                showInfoMessages();
                print("Имеются несохранённые изменения. Сохранить перед выходом?\n");
                print("\t1. Да\n");
                print("\t2. Нет\n");
                print("\t3. Назад\n");

                String choice = getCommand();

                switch (choice) {
                    case "1" -> {
                        try {
                            this.presenter.saveChanges();
                            return false;
                        } catch (Exception e) {
                            infoMessages.add(e.getMessage());
                        }
                    }
                    case "2" -> {
                        return false;
                    }
                    case "3" -> {
                        return true;
                    }
                    default -> this.infoMessages.add("ОШИБКА: Команда не распознана.");
                }
            }
        }
    }
}
