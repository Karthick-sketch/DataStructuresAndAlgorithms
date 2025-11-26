package datastructures.linear;

public class Queue<Q> {

  private Node<Q> first;
  private Node<Q> last;

  public void enqueue(Q value) {
    Node<Q> node = new Node<>(value);
    if (first == null) {
      first = node;
    } else {
      last.next = node;
    }
    last = node;
  }

  public Q dequeue() {
    Node<Q> temp = first;
    first = first.next;
    if (first == null) {
      last = null;
    }
    return temp.value;
  }

  class Node<T> {

    private T value;
    private Node<T> next;

    Node(T value) {
      this.value = value;
      this.next = null;
    }
  }
}
