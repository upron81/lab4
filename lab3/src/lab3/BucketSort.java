package lab3;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int[] array, int numOfBuckets) {
        if (array.length == 0) return;

        int maxVal = array[0];
        int minVal = array[0];
        for (int num : array) {
            if (num > maxVal) maxVal = num;
            if (num < minVal) minVal = num;
        }

        int bucketRange = (maxVal - minVal) / numOfBuckets + 1;

        ArrayList<Integer>[] buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : array) {
            int bucketIndex = (num - minVal) / bucketRange;
            buckets[bucketIndex].add(num);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }


    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
