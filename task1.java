package homeworks.homework1;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        // Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
        //(произведение чисел от 1 до n)

        // Tn = n*(n+1)/2 - общая формула для n-го по порядку треугольного числа

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число n = ");
        int n = iScanner.nextInt(); // без проверки ввода от пользователя
        iScanner.close();

        int Tn;
        Tn = (n*(n+1))/2;
        System.out.printf("Треугольное число для n = %d: %d\n", n, Tn);

        int factorial = 1;
        if (n == 0 && n == 1) {
            factorial = 1;
        } else {
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
        }
        System.out.printf("Факториал для числа n = %d: n! = %d", n, factorial);

    }
}
