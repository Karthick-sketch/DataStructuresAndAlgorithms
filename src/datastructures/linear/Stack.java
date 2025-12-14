package datastructures.linear;

import datastructures.linear.node.Node;

public class Stack<S> {

  private Node<S> top;

  public void push(S value) {
    Node<S> node = new Node<>(value);
    node.setNext(top);
    top = node;
  }

  public S pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }
    Node<S> node = top;
    top = top.getNext();
    return node.getValue();
  }

  public boolean isEmpty() {
    return top == null;
  }
}
