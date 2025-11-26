package operations;

import algorithms.sort.*;

import java.util.Arrays;

public class SortOperations {
  public static void operations() {
    int[] arr = Randomize.randomizeArray(10);
    System.out.println("Unsorted:\t" + Arrays.toString(arr));
    operations(arr, new BubbleSort(), "Bubble");
    operations(arr, new SelectionSort(), "Selection");
    operations(arr, new InsertionSort(), "Insertion");
    operations(arr, new MergeSort(), "Merge");
    operations(arr, new QuickSort(), "Quick");
  }

  private static void operations(int[] arr, Sort sort, String name) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    sort.sort(copy);
    System.out.printf("%s Sort:\t%s", name, Arrays.toString(copy));
  }
}
