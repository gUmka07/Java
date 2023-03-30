
public class Main {

    public static void main(String[] args) {
        Integer[] values = {4, 12, 5, 53, 77, 19, 18, 68, 99}; 
        DynamicArray<Integer> myArray = new DynamicArray<>(values);
    
    System.out.print("Изначальный массив: ");
    myArray.print();

    System.out.println("Массив содержит значение 99? " + myArray.contains(99));
    System.out.println("Массив содержит значение 105? " + myArray.contains(105));

    System.out.println("Длина массива: " + myArray.getLength());
    System.out.println("Сумма элементов массива: " + myArray.sum());
    System.out.println("Произведение элементов массива: " + myArray.product());

    System.out.println("Индекс элемента со значением 12: " + myArray.getIndex(12));

    System.out.println("Максимальное значение: " + myArray.getMax());

    System.out.println("Минимальное значение: " + myArray.getMin());

    System.out.println("Элемент по индексу 4: " + myArray.get(4));


    myArray.removeByIndex(2);
    System.out.print("Массив после удаления элемента по индексу 2: ");
    myArray.print();


    myArray.removeByValue(99);
    System.out.print("Массив после удаления элемента со значением 99: ");
    myArray.print();


    myArray.insert(68);
    System.out.print("Массив после добавления элемента со значением 123: ");
    myArray.print();
    myArray.set(0, 13);
    System.out.print("Массив после изменения элемента по индексу 0 на 567: ");
    myArray.print();

    myArray.bubbleSort();
    System.out.print("Массив после сортировки пузырьком: ");
    myArray.print();


    DynamicArray<Integer> newArray = new DynamicArray<>(values);
    System.out.print("\nИзначальный массив: ");
    newArray.print();
    newArray.selectionSort();
    System.out.print("Массив после сортировки выбором:");
    newArray.print();

    DynamicArray<Integer> array = new DynamicArray<>(values);
    System.out.print("\nИзначальный массив: ");
    array.print();
    array.insertionSort();
    System.out.print("Массив после сортировки вставками: ");
    array.print();

    String[] array2 = {"g", "U", "m", "k", "a"};
    DynamicArray<String> strArray = new DynamicArray<>(array2);
    System.out.println("Склеивание строк: " + strArray.sum());
  }
}
