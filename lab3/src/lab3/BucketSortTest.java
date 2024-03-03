package lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BucketSortTest {
    @Test
    void testBucketSortWithPositiveNumbers() {
        int[] array = {5, 3, 2, 8, 1, 4};
        BucketSort.bucketSort(array, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 8}, array);
    }

    @Test
    void testBucketSortWithNegativeNumbers() {
        int[] array = {-3, -1, -4, -2};
        BucketSort.bucketSort(array, 2);
        assertArrayEquals(new int[]{-4, -3, -2, -1}, array);
    }

    @Test
    void testBucketSortWithMixedNumbers() {
        int[] array = {-5, 4, -3, 2, 1};
        BucketSort.bucketSort(array, 5);
        assertArrayEquals(new int[]{-5, -3, 1, 2, 4}, array);
    }

    @Test
    void testBucketSortWithSingleElement() {
        int[] array = {42};
        BucketSort.bucketSort(array, 1);
        assertArrayEquals(new int[]{42}, array);
    }

    @Test
    void testBucketSortWithEmptyArray() {
        int[] array = {};
        BucketSort.bucketSort(array, 3);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void testBucketSortWithIdenticalElements() {
        int[] array = {7, 7, 7, 7};
        BucketSort.bucketSort(array, 2);
        assertArrayEquals(new int[]{7, 7, 7, 7}, array);
    }

    @Test
    void testBucketSortWithZerosAndNegatives() {
        int[] array = {0, -1, -2, 0};
        BucketSort.bucketSort(array, 2);
        assertArrayEquals(new int[]{-2, -1, 0, 0}, array);
    }

    @Test
    void testBucketSortWithLargeNumbers() {
        int[] array = {1000, 2000, 1500, 500};
        BucketSort.bucketSort(array, 4);
        assertArrayEquals(new int[]{500, 1000, 1500, 2000}, array);
    }

    @Test
    void testBucketSortWithLargeNumberOfBuckets() {
        int[] array = {5, 3, 2, 8, 1, 4};
        BucketSort.bucketSort(array, 6);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 8}, array);
    }

    @Test
    void testBucketSortWithMoreComplexArray() {
        int[] array = {33, 22, 55, 44, 11, 66, 77};
        BucketSort.bucketSort(array, 3);
        assertArrayEquals(new int[]{11, 22, 33, 44, 55, 66, 77}, array);
    }

    @Test
    void testBucketSortWithDecimals() {
        int[] array = {9, 7, 5, 3, 2, 8, 1, 4, 6};
        BucketSort.bucketSort(array, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void testBucketSortWithBackwardsArray() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        BucketSort.bucketSort(array, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void testBucketSortWithAllZeros() {
        int[] array = {0, 0, 0, 0};
        BucketSort.bucketSort(array, 2);
        assertArrayEquals(new int[]{0, 0, 0, 0}, array);
    }

    @Test
    void testBucketSortWithVerySmallAndLargeNumbers() {
        int[] array = {-1000, 2000, 0, -500, 1500, 500};
        BucketSort.bucketSort(array, 4);
        assertArrayEquals(new int[]{-1000, -500, 0, 500, 1500, 2000}, array);
    }

    @Test
    void testBucketSortWithRandomNumbers() {
        int[] array = {42, 24, 12, 56, 78, 67, 89, 23, 45};
        BucketSort.bucketSort(array, 5);
        assertArrayEquals(new int[]{12, 23, 24, 42, 45, 56, 67, 78, 89}, array);
    }

    @Test
    void testBucketSortWithALongArray() {
        int[] array = new int[100];
        int[] expected = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = 100 - i;
        }

        for (int i = 0; i < 100; i++) {
            expected[i] = i + 1;
        }

        BucketSort.bucketSort(array, 10);

        assertArrayEquals(expected, array);
    }

}
