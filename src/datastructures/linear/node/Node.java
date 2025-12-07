package datastructures.linear.node;

public class Node<N> {

  private N value;
  private Node<N> next;

  public Node(N value) {
    this.value = value;
    this.next = null;
  }

  public N getValue() {
    return value;
  }

  public void setValue(N value) {
    this.value = value;
  }

  public Node<N> getNext() {
    return next;
  }

  public void setNext(Node<N> next) {
    this.next = next;
  }
}
