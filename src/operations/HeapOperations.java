package operations;

import datastructures.nonlinear.heap.Heap;
import java.util.Arrays;

public class HeapOperations {

  public static void operations() {
    Heap heap = new Heap();

    int[] arr1 = { 4, 2, 6, 1, 3, 5, 7 };
    int[] arr2 = { 4, 2, 6, 1, 3, 5, 7 };
    System.out.println("Array: " + Arrays.toString(arr1));
    heap.maxHeap(arr1);
    heap.minHeap(arr2);
    System.out.println("Max Heap: " + Arrays.toString(arr1));
    System.out.println("Min Heap: " + Arrays.toString(arr2));
  }
}
