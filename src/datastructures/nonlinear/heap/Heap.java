package datastructures.nonlinear.heap;

import helper.Helper;

public class Heap {

  public void maxHeap(int[] array) {
    maxHeap(array, array.length);
  }

  public void minHeap(int[] array) {
    minHeap(array, array.length);
  }

  public void maxHeap(int[] array, int length) {
    for (int i = length - 1; i > 0; i--) {
      maxHeapify(array, i);
      Helper.swap(array, 0, i);
    }
  }

  public void minHeap(int[] array, int length) {
    for (int i = length - 1; i > 0; i--) {
      minHeapify(array, i);
      Helper.swap(array, 0, i);
    }
  }

  private void maxHeapify(int[] array, int length) {
    for (int i = length; i > 0; i--) {
      int j = (int) ((i - 1) / 2.0);
      if (array[i] > array[j]) {
        Helper.swap(array, i, j);
      }
    }
  }

  private void minHeapify(int[] array, int length) {
    for (int i = length; i > 0; i--) {
      int j = (int) ((i - 1) / 2.0);
      if (array[i] < array[j]) {
        Helper.swap(array, i, j);
      }
    }
  }
}
