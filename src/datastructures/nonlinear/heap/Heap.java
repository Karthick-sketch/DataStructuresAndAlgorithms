package datastructures.nonlinear.heap;

public class Heap {

  public void maxHeap(Integer[] array) {
    maxHeap(array, array.length);
  }

  public void minHeap(Integer[] array) {
    minHeap(array, array.length);
  }

  public void maxHeap(Integer[] array, int length) {
    for (int i = length - 1; i > 0; i--) {
      maxHeapify(array, i);
      swap(array, 0, i);
    }
  }

  public void minHeap(Integer[] array, int length) {
    for (int i = length - 1; i > 0; i--) {
      minHeapify(array, i);
      swap(array, 0, i);
    }
  }

  private void maxHeapify(Integer[] array, int length) {
    for (int i = length; i > 0; i--) {
      int j = (int) ((i - 1) / 2.0);
      if (array[i] > array[j]) {
        swap(array, i, j);
      }
    }
  }

  private void minHeapify(Integer[] array, int length) {
    for (int i = length; i > 0; i--) {
      int j = (int) ((i - 1) / 2.0);
      if (array[i] < array[j]) {
        swap(array, i, j);
      }
    }
  }

  private void swap(Integer[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
