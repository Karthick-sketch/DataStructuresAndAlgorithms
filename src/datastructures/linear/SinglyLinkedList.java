package datastructures.linear;

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
        node = node.next;
      }
      return node.value;
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
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = node;
    }
    length++;
  }

  @Override
  public void insert(L value, int index) {
    if (index >= 0 && index <= length) {
      Node<L> node = new Node<>(value);
      if (index == 0) {
        node.next = head;
        head = node;
      } else {
        Node<L> temp = head;
        for (int i = 1; i < index; i++) {
          temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
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
        temp = temp.next;
      }
      temp.value = value;
    } else {
      throw new IndexOutOfBoundsException(index);
    }
  }

  @Override
  public L delete(int index) {
    if (index >= 0 && index < length) {
      Node<L> node = head;
      if (index == 0) {
        head = head.next;
      } else {
        Node<L> temp = head;
        for (int i = 1; i < index; i++) {
          temp = temp.next;
        }
        node = temp.next;
        temp.next = node.next;
      }
      length--;
      return node.value;
    }
    throw new IndexOutOfBoundsException(index);
  }

  @Override
  public String toString() {
    String values = "[";
    Node<L> temp = head;
    while (temp.next != null) {
      values += temp.value + ", ";
      temp = temp.next;
    }
    return values + temp.value + "]";
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
