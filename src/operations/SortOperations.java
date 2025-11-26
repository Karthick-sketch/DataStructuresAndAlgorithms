package operations;

import algorithms.sort.Sort;
import java.util.Arrays;
import java.util.Random;

public class SortOperations {

  public static void operations() {
    operations(randomize(10));
  }

  private static int[] randomize(int length) {
    Random random = new Random();
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = random.nextInt(100);
    }
    return arr;
  }

  private static void operations(int[] arr1) {
    int[] arr2 = Arrays.copyOf(arr1, arr1.length);
    int[] arr3 = Arrays.copyOf(arr1, arr1.length);
    int[] arr4 = Arrays.copyOf(arr1, arr1.length);
    int[] arr5 = Arrays.copyOf(arr1, arr1.length);
    System.out.println("Unsorted:\t" + Arrays.toString(arr1));
    Sort.bubbleSort(arr1);
    System.out.println("Bubble sort:\t" + Arrays.toString(arr1));
    Sort.selectionSort(arr2);
    System.out.println("Selection sort:\t" + Arrays.toString(arr2));
    Sort.insertionSort(arr3);
    System.out.println("Insertion sort:\t" + Arrays.toString(arr3));
    Sort.mergeSort(arr4);
    System.out.println("Merge sort:\t" + Arrays.toString(arr4));
    Sort.quickSort(arr5);
    System.out.println("Quick sort:\t" + Arrays.toString(arr5));
  }
}
