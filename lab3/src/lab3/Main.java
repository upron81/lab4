package lab3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов в массиве:"); // Изменение вывода на русский
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Введите " + n + " целых чисел:"); // Изменение вывода на русский
        for (int i = 0; i < n; i++) {
            try {
                array[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, вводите только целые числа. Перезапустите программу и попробуйте снова."); // Изменение вывода на русский
                return;
            }
        }

        int numOfBuckets;
        while (true) {
            System.out.println("Введите количество корзин:"); // Изменение вывода на русский
            try {
                numOfBuckets = scanner.nextInt();
                if (numOfBuckets <= 0) {
                    System.out.println("Количество корзин должно быть положительным целым числом. Попробуйте снова."); // Изменение вывода на русский
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите корректное целое число для количества корзин."); // Изменение вывода на русский
                scanner.next();
            }
        }

        System.out.println("\nПеред сортировкой:"); // Изменение вывода на русский
        BucketSort.printArray(array);

        BucketSort.bucketSort(array, numOfBuckets);

        System.out.println("\nПосле сортировки корзинами:"); // Изменение вывода на русский
        BucketSort.printArray(array);
    }
}
