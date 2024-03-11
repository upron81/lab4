package lab3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            try {
                array[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter only integers. Restart the program and try again.");
                return;
            }
        }

        int numOfBuckets;
        while (true) {
            System.out.println("Enter the number of buckets:");
            try {
                numOfBuckets = scanner.nextInt();
                if (numOfBuckets <= 0) {
                    System.out.println("Number of buckets should be a positive integer. Please try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer for the number of buckets.");
                scanner.next();
            }
        }

        System.out.println("\nBefore sorting:");
        BucketSort.printArray(array);

        BucketSort.bucketSort(array, numOfBuckets);

        System.out.println("\nAfter Bucket Sort:");
        BucketSort.printArray(array);
    }
}
