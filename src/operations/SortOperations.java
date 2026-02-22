package operations;

import algorithms.Sort;
import java.util.Arrays;

public class SortOperations {

  public static void operations() {
    int[] arr = OperationHelper.randomizeArray(10);
    System.out.println("Unsorted:\t" + Arrays.toString(arr));

    int[] arr1 = Arrays.copyOf(arr, arr.length);
    Sort.bubbleSort(arr1);
    System.out.println("Bubble Sort:\t%s" + Arrays.toString(arr1));

    int[] arr2 = Arrays.copyOf(arr, arr.length);
    Sort.selectionSort(arr2);
    System.out.println("Selection Sort:\t%s" + Arrays.toString(arr2));

    int[] arr3 = Arrays.copyOf(arr, arr.length);
    Sort.insertionSort(arr3);
    System.out.println("Insertion Sort:\t%s" + Arrays.toString(arr3));

    int[] arr4 = Arrays.copyOf(arr, arr.length);
    Sort.mergeSort(arr4);
    System.out.println("Merge Sort:\t%s" + Arrays.toString(arr4));

    int[] arr5 = Arrays.copyOf(arr, arr.length);
    Sort.quickSort(arr5);
    System.out.println("Quick Sort:\t%s" + Arrays.toString(arr5));

    int[] arr6 = Arrays.copyOf(arr, arr.length);
    Sort.heapSort(arr6);
    System.out.println("Heap Sort:\t%s" + Arrays.toString(arr6));
  }
}
