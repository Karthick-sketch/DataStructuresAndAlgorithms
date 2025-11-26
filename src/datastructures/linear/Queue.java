package datastructures.linear;

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
    Node<Q> temp = first;
    first = first.getNext();
    if (first == null) {
      last = null;
    }
    return temp.getValue();
  }
}
