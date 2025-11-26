package datastructures.linear;

public class Stack<S> {

  private Node<S> top;

  public void push(S value) {
    Node<S> node = new Node<>(value);
    node.next = top;
    top = node;
  }

  public S pop() {
    Node<S> node = top;
    top = top.next;
    return node.value;
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
