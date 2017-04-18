package ru.loginov.test.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] numbers = {55, 2, 93, 1, 23, 10, 5, 66, 12, 7, 54, 3, 4};
        System.out.println(Arrays.toString(numbers));
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] a) {
        int n = a.length - 1;
        for (int i = 0; i < n / 2; i++) {
            heapify(a, i, n);
        }
        System.out.println("\n-----tree was built-----");
        for (int i = n; i > 0; i--) {
            System.out.println("\nswapping first");
            swap(a, 0, i);
            n--;
            heapify(a, 0, n);
        }
    }

    private static void heapify(int[] a, int i, int n) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        System.out.println(String.format("%s   n=%2s  |  i=%2s,  left=%2s,  right=%2s  |  a[i]=%2s,  a[l]=%2s,  a[r]=%2s",
                Arrays.toString(a),
                n, i, leftIndex, rightIndex,
                a[i],
                leftIndex <= n ? a[leftIndex] : "--",
                rightIndex <= n ? a[rightIndex] : "--")
        );

        int largestIndex = leftIndex <= n && a[leftIndex] > a[i] ? leftIndex : i;
        if (rightIndex <= n && a[rightIndex] > a[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != i) {
            swap(a, i, largestIndex);
            heapify(a, largestIndex, n);
        }
    }

    private static void swap(int[] a, int i, int j) {
        System.out.println(String.format("%s <-> %s", a[i], a[j]));
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
