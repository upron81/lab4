package lab3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов в массиве:"); // Поменял вывод на русский
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Введите " + n + " целых чисел:"); // Поменял вывод на русский
        for (int i = 0; i < n; i++) {
            try {
                array[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, вводите только целые числа. Перезапустите программу и попробуйте снова."); // Поменял вывод на русский
                return;
            }
        }

        int numOfBuckets;
        while (true) {
            System.out.println("Введите количество корзин:"); // Поменял вывод на русский
            try {
                numOfBuckets = scanner.nextInt();
                if (numOfBuckets <= 0) {
                    System.out.println("Количество корзин должно быть положительным целым числом. Попробуйте снова."); // Поменял вывод на русский
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите корректное целое число для количества корзин."); // Поменял вывод на русский
                scanner.next();
            }
        }

        System.out.println("\nПеред сортировкой:"); // Поменял вывод на русский
        BucketSort.printArray(array);

        BucketSort.bucketSort(array, numOfBuckets);

        System.out.println("\nПосле сортировки корзинами:"); // Поменял вывод на русский
        BucketSort.printArray(array);
    }
}
