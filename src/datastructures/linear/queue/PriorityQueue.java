package datastructures.linear.queue;

import datastructures.nonlinear.heap.Heap;

public class PriorityQueue {

  private Heap heap;
  private int[] array;
  private int length;
  private boolean isHighPriority;

  public PriorityQueue(boolean isHighPriority) {
    this.heap = new Heap();
    this.array = new int[10];
    this.length = -1;
    this.isHighPriority = isHighPriority;
  }

  public PriorityQueue(int[] array, boolean isHighPriority) {
    this.heap = new Heap();
    this.array = array;
    this.length = array.length;
    this.isHighPriority = isHighPriority;
  }

  public void enqueue(int value) {
    if (array.length == length) {
      extendArray();
    }
    length++;
    array[length] = value;
    heapify();
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
    int value = array[0];
    adjustArray();
    heapify();
    return value;
  }

  public boolean isEmpty() {
    return length < 0;
  }

  private void extendArray() {
    int[] temp = array;
    array = new int[temp.length + 10];
    for (int i = 0; i < temp.length; i++) {
      array[i] = temp[i];
    }
  }

  private void adjustArray() {
    array[0] = array[length];
    array[length] = 0;
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
