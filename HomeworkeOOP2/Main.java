import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo();
        myZoo.addAnimal(new Cat(24.5, 3.5, "зеленый", "Бакс",
                "британец", "да", "серый", "10.05.2010", "да"));
        myZoo.addAnimal(new Dog(65.0, 35.0, "коричневый", "Мухтар",
                "немецкая овчарка", "да", "черно-коричневый",
                "15.04.2020", "да"));
        myZoo.addAnimal(new Tiger(110.0, 200.0, "желтый", "Камбоджа",
                "неизвестно"));
        myZoo.addAnimal(new Wolf(82.5, 55.6, "желтый", "Тайга",
                "неизвестно", "да"));
        myZoo.addAnimal(new Chicken(30.0, 1.5, "оранжевый"));
        myZoo.addAnimal(new Stork(105.50, 3.4, "серый"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить животное в зоопарк");
            System.out.println("2. Убрать животное из зоопарка");
            System.out.println("3. Посмотреть информацию о животном");
            System.out.println("4. Заставить животное издать звук");
            System.out.println("5. Напечатать информацию о животных в зоопарке");
            System.out.println("6. Заставить всех животных издать звук");
            System.out.println("0. Выход");

            int choice = sc.nextInt();
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    addAnimalZoo(sc, myZoo);
                    System.out.println("Животное успешно добавлено в зоопарк\n");
                    break;
                case 2:
                    System.out.print("Введите номер животного: ");
                    int number = sc.nextInt();
                    myZoo.removeAnimal(number);
                    System.out.println("Животное успешно удалено из зоопарка\n");
                    break;
                case 3:
                    System.out.print("Введите номер животного: ");
                    number = sc.nextInt();
                    myZoo.viewAnimal(number);
                    break;
                case 4:
                    System.out.print("Введите номер животного: ");
                    number = sc.nextInt();
                    myZoo.makeAnimalSound(number);
                    break;
                case 5:
                    myZoo.printAnimals();
                    break;
                case 6:
                    myZoo.makeAllSound();
                    break;
            }
        }
        sc.close();
        showActive(myZoo);

    }

    static void showActive(Zoo zoo) {
        Iterator<Animals> iterator = zoo.iterator();
        while (iterator.hasNext()) {
            Animals animal = iterator.next();
            if (animal instanceof ShowAffection) {
                System.out.print(animal.getClass().getSimpleName() + ": ");
                ((ShowAffection) animal).showAffection();
            }
            if (animal instanceof Training) {
                System.out.print(animal.getClass().getSimpleName() + ": ");
                ((Training) animal).training();
            }
            if (animal instanceof Fly) {
                System.out.print(animal.getClass().getSimpleName() + ": ");
                ((Fly) animal).fly();
            }

        }
        System.out.println();
    }


    static void addAnimalZoo(Scanner sc, Zoo zoo) {
        System.out.print("Введите высоту животного: ");
        double growth = sc.nextDouble();
        System.out.print("Введите вес животного: ");
        double weight = sc.nextDouble();
        System.out.print("Введите цвет глаз: ");
        String eyeColor = sc.next();

        System.out.println();
        System.out.println("Выберите животное:");
        System.out.println("1. Кот");
        System.out.println("2. Тигр");
        System.out.println("3. Аист");
        System.out.println("4. Курица");
        System.out.println("5. Волк");
        System.out.println("6. Собака");


        int choiceAnimal = sc.nextInt();

        switch (choiceAnimal){
            case 1:
                System.out.print("Введите кличку кота: ");
                String name = sc.next();
                System.out.print("Введите породу кота: ");
                String breed = sc.next();
                System.out.print("Кот привит (да/нет): ");
                String vaccination = sc.next();
                System.out.print("Введите цвет окраса кота: ");
                String woolColor = sc.next();
                System.out.print("Введите дату рождения кота: ");
                String dataBirth = sc.next();
                System.out.print("Есть ли у кота шерсть?(да/нет): ");
                String haveWool = sc.next();


                zoo.addAnimal(new Cat(growth, weight, eyeColor, name, breed, vaccination,
                        woolColor, dataBirth, haveWool));
                break;
            case 2:
                System.out.print("Введите среду обитания: ");
                String habitat = sc.next();
                System.out.print("Введите дату рождения: ");
                dataBirth = sc.next();
                zoo.addAnimal(new Tiger(growth, weight, eyeColor, habitat, dataBirth));
                break;
            case 3:
                zoo.addAnimal(new Stork(growth, weight, eyeColor));
                break;
            case 4:
                zoo.addAnimal(new Chicken(growth, weight, eyeColor));
                break;
            case 5:
                System.out.print("Введите среду обитания: ");
                habitat = sc.next();
                System.out.print("Введите дату рождения: ");
                dataBirth = sc.next();
                System.out.print("Вожак стаи? (да/нет): ");
                String leader = sc.next();
                zoo.addAnimal(new Wolf(growth, weight, eyeColor, habitat, dataBirth,leader));
                break;
            case 6:
                System.out.print("Введите кличку собаки: ");
                name = sc.next();
                System.out.print("Введите породу собаки: ");
                breed = sc.next();
                System.out.print("Собака привита (да/нет): ");
                vaccination = sc.next();
                System.out.print("Введите цвет окраса собаки: ");
                woolColor = sc.next();
                System.out.print("Введите дату рождения собаки: ");
                dataBirth = sc.next();
                System.out.print("Собака дрессирована?(да/нет): ");
                String haveTraining = sc.next();


                zoo.addAnimal(new Dog(growth, weight, eyeColor, name, breed, vaccination,
                        woolColor, dataBirth, haveTraining));
                break;


        }
    }

}