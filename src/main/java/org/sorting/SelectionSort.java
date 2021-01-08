package org.sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void swap(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }

    private static void selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmpMin = arr[i];
            int tmpMinIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < tmpMin) {
                    tmpMin = arr[j];
                    tmpMinIdx = j;
                }
            }
            swap(arr, i, tmpMinIdx);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{41, 33, 17, 80, 61, 5, 55};
        selectionSorting(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " ,"));
    }

}
