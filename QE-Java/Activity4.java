package com.example;

public class Activity4 {
   
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];  
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,10,12,1,5,6};

        System.out.println("Before sorting:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("After sorting:");
        printArray(arr);
    }
}



