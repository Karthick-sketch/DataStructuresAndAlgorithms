package datastructures.linear.list;

import datastructures.linear.node.DoublyNode;

public class DoublyLinkedList<L> implements List<L> {

  private DoublyNode<L> head;
  private int length;

  @Override
  public int size() {
    return length;
  }

  @Override
  public L get(int index) {
    if (index >= 0 && index < length) {
      DoublyNode<L> node = head;
      for (int i = 0; i < index; i++) {
        node = node.getNext();
      }
      return node.getValue();
    }
    throw new IndexOutOfBoundsException(index);
  }

  @Override
  public void add(L value) {
    DoublyNode<L> node = new DoublyNode<>(value);
    if (head == null) {
      head = node;
    } else {
      DoublyNode<L> temp = head;
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(node);
      node.setPrevious(temp);
    }
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
      DoublyNode<L> temp = head;
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
      DoublyNode<L> node = new DoublyNode<>(value);
      if (index == 0) {
        node.setNext(head);
        head.setPrevious(node);
        head = node;
      } else {
        DoublyNode<L> temp = head;
        for (int i = 1; i < index; i++) {
          temp = temp.getNext();
        }
        if (temp.getNext() != null) {
          node.setNext(temp.getNext());
          temp.getNext().setPrevious(node);
        }
        temp.setNext(node);
        node.setPrevious(temp);
      }
      length++;
    } else {
      throw new IndexOutOfBoundsException(index);
    }
  }

  @Override
  public L remove(int index) {
    if (index >= 0 && index < length) {
      DoublyNode<L> temp = head;
      if (index == 0) {
        head = head.getNext();
        head.setPrevious(null);
      } else {
        for (int i = 1; i <= index; i++) {
          temp = temp.getNext();
        }
        temp.getPrevious().setNext(temp.getNext());
      }
      length--;
      return temp.getValue();
    }
    throw new IndexOutOfBoundsException(index);
  }

  @Override
  public L remove(L value) {
    DoublyNode<L> current = head, previous = null;
    while (current != null) {
      if (current.getValue().equals(value)) {
        L obj = current.getValue();
        if (previous == null) {
          head = head.getNext();
        } else {
          previous.setNext(current.getNext());
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
    DoublyNode<L> temp = head;
    while (temp.getNext() != null) {
      values.append(temp.getValue()).append(", ");
      temp = temp.getNext();
    }
    return values.toString() + temp.getValue() + "]";
  }

  @Override
  public void clear() {
    head = null;
    length = 0;
  }
}
