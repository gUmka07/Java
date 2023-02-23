package homeworks.homework1;


public class task4 {
    public static void main(String[] args) {
        // *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры
        // могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется
        // восстановить выражение до верного равенства. Предложить хотя бы
        // одно решение или сообщить, что его нет.

        String str = "2? + 51 = ?9";
        String [] arr = str.split(" ");
        String q = arr[0];
        String w = arr[2];
        String z = arr[arr.length - 1];
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
           int qNum = Integer.parseInt(q.replace("?", Integer.toString(i)));
            for (int j =0; j < 10; j++) {
                int wNum = Integer.parseInt(w.replace("?", Integer.toString(j)));
                for (int k = 0; k < 10; k++) {
                    int zNum = Integer.parseInt(z.replace("?", Integer.toString(k)));
                    if (qNum + wNum == zNum) {
                        System.out.printf("Решение уравнения %s => %d + %d = %d\n", 
                        str, qNum, wNum, zNum);
                        flag = false;
                        break;
                    }
                }
                if (flag == false) break;
            }
            if (flag == false) break;
        } 
        if (flag) System.out.println("Решений нет!");
    }
}
