package org.sorting;

import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{41, 33, 17, 80, 61, 5, 55};
        bubbleSorting(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " ,"));
    }

}
