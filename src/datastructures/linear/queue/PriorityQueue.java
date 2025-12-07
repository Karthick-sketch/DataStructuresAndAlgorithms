package datastructures.linear.queue;

import datastructures.nonlinear.heap.Heap;

public class PriorityQueue {

  private Heap heap;
  private Integer[] array;
  private int length;
  private boolean isHighPriority;

  public PriorityQueue(boolean isHighPriority) {
    this.heap = new Heap();
    this.array = new Integer[10];
    this.length = -1;
    this.isHighPriority = isHighPriority;
  }

  public PriorityQueue(Integer[] array, boolean isHighPriority) {
    this.heap = new Heap();
    this.array = array;
    this.length = array.length;
    this.isHighPriority = isHighPriority;
  }

  public void enqueue(Integer value) {
    if (array.length == length) {
      extendArray();
    }
    length++;
    array[length] = value;
    heapify();
  }

  public Integer dequeue() {
    Integer value = array[0];
    adjustArray();
    heapify();
    return value;
  }

  private void extendArray() {
    Integer[] temp = array;
    array = new Integer[temp.length + 10];
    for (int i = 0; i < temp.length; i++) {
      array[i] = temp[i];
    }
  }

  private void adjustArray() {
    array[0] = array[length];
    array[length] = null;
    length--;
  }

  private void heapify() {
    if (isHighPriority) {
      heap.minHeap(array, length);
    } else {
      heap.maxHeap(array, length);
    }
  }
}
