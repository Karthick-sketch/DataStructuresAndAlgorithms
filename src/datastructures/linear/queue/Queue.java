package datastructures.linear.queue;

import datastructures.linear.node.Node;

public class Queue<Q> {

  private Node<Q> first;
  private Node<Q> last;

  public void enqueue(Q value) {
    Node<Q> node = new Node<>(value);
    if (first == null) {
      first = node;
    } else {
      last.setNext(node);
    }
    last = node;
  }

  public Q dequeue() {
    checkQueueIsEmpty();
    Node<Q> temp = first;
    first = first.getNext();
    if (first == null) {
      last = null;
    }
    return temp.getValue();
  }

  public Q peek() {
    checkQueueIsEmpty();
    return first.getValue();
  }

  public boolean isEmpty() {
    return first == null;
  }

  private void checkQueueIsEmpty() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
  }
}
