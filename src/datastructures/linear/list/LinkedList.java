package datastructures.linear.list;

import datastructures.linear.node.Node;

public class LinkedList<L> implements List<L> {

  private Node<L> head;
  private Node<L> tail;
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
      tail.setNext(node);
    }
    tail = node;
    length++;
  }

  @Override
  public void addAll(L[] values) {
    for (L value : values) {
      add(value);
    }
  }

  @Override
  public void set(L value, int index) {
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
  public void insert(L value, int index) {
    if (index >= 0 && index <= length) {
      Node<L> node = new Node<>(value);
      if (index == 0) {
        node.setNext(head);
        head = node;
      } else if (index == length) {
        tail.setNext(node);
        tail = node;
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
  public L remove(int index) {
    if (index >= 0 && index < length) {
      Node<L> node = head;
      if (index == 0) {
        head = head.getNext();
        if (head == null) {
          tail = null;
        }
      } else {
        Node<L> temp = head;
        for (int i = 1; i < index; i++) {
          temp = temp.getNext();
        }
        node = temp.getNext();
        temp.setNext(node.getNext());
        if (node == tail) {
          tail = temp;
        }
      }
      length--;
      return node.getValue();
    }
    throw new IndexOutOfBoundsException(index);
  }

  @Override
  public L remove(L value) {
    Node<L> current = head, previous = null;
    while (current != null) {
      if (current.getValue().equals(value)) {
        L obj = current.getValue();
        if (previous == null) {
          head = head.getNext();
        } else {
          previous.setNext(current.getNext());
        }
        if (current == tail) {
          tail = previous;
        }
        length--;
        return obj;
      }
      previous = current;
      current = current.getNext();
    }
    throw new RuntimeException(value + " is not exist");
  }

  @Override
  public String toString() {
    if (head == null) {
      return "[]";
    }
    StringBuilder values = new StringBuilder("[");
    Node<L> temp = head;
    while (temp.getNext() != null) {
      values.append(temp.getValue()).append(", ");
      temp = temp.getNext();
    }
    return values.toString() + temp.getValue() + "]";
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    length = 0;
  }

  @Override
  public boolean isEmpty() {
    return length == 0;
  }
}
