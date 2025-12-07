package datastructures.linear.linkedlist;

import datastructures.linear.node.Node;

public class SinglyLinkedList<L> implements LinkedList<L> {

  private Node<L> head;
  private int length;

  @Override
  public int size() {
    return length;
  }

  @Override
  public L get(int index) {
    if (index >= 0 && index < length) {
      Node<L> node = head;
      for (int i = 0; i < index; i++) {
        node = node.getNext();
      }
      return node.getValue();
    }
    throw new IndexOutOfBoundsException(index);
  }

  @Override
  public void add(L value) {
    Node<L> node = new Node<>(value);
    if (head == null) {
      head = node;
    } else {
      Node<L> temp = head;
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(node);
    }
    length++;
  }

  @Override
  public void insert(L value, int index) {
    if (index >= 0 && index <= length) {
      Node<L> node = new Node<>(value);
      if (index == 0) {
        node.setNext(head);
        head = node;
      } else {
        Node<L> temp = head;
        for (int i = 1; i < index; i++) {
          temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
      }
      length++;
    } else {
      throw new IndexOutOfBoundsException(index);
    }
  }

  @Override
  public void update(L value, int index) {
    if (index >= 0 && index < length) {
      Node<L> temp = head;
      for (int i = 1; i <= index; i++) {
        temp = temp.getNext();
      }
      temp.setValue(value);
    } else {
      throw new IndexOutOfBoundsException(index);
    }
  }

  @Override
  public L delete(int index) {
    if (index >= 0 && index < length) {
      Node<L> node = head;
      if (index == 0) {
        head = head.getNext();
      } else {
        Node<L> temp = head;
        for (int i = 1; i < index; i++) {
          temp = temp.getNext();
        }
        node = temp.getNext();
        temp.setNext(node.getNext());
      }
      length--;
      return node.getValue();
    }
    throw new IndexOutOfBoundsException(index);
  }

  @Override
  public String toString() {
    StringBuilder values = new StringBuilder("[");
    Node<L> temp = head;
    while (temp.getNext() != null) {
      values.append(temp.getNext()).append(", ");
      temp = temp.getNext();
    }
    return values.toString() + temp.getNext() + "]";
  }
}
