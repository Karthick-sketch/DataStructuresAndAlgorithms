package algorithms.sort;

import datastructures.nonlinear.heap.Heap;

public class HeapSort implements Sort {

  private Heap heap;

  public HeapSort() {
    this.heap = new Heap();
  }

  @Override
  public void sort(int[] array) {
    heap.maxHeap(array);
  }
}
