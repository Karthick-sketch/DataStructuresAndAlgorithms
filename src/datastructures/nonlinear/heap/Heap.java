package datastructures.nonlinear.heap;

public class Heap {

  public void maxHeap(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {
      maxHeapify(array, i);
      swap(array, 0, i);
    }
  }

  private void maxHeapify(int[] array, int len) {
    for (int i = len; i > 0; i--) {
      int j = (int) ((i - 1) / 2.0);
      if (array[i] > array[j]) {
        swap(array, i, j);
      }
    }
  }

  public void minHeap(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {
      minHeapify(array, i);
      swap(array, 0, i);
    }
  }

  private void minHeapify(int[] array, int len) {
    for (int i = len; i > 0; i--) {
      int j = (int) ((i - 1) / 2.0);
      if (array[i] < array[j]) {
        swap(array, i, j);
      }
    }
  }

  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
