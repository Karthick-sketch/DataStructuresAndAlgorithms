package datastructures.nonlinear.hash;

public class LinkedMap<K, V> implements Map<K, V> {

  private Entry<K, V> head;

  @Override
  public void add(K key, V value) {
    if (head == null) {
      head = new Entry<>(key, value);
    } else if (head.getKey().equals(key)) {
      head.setValue(value);
    } else {
      Entry<K, V> current = head;
      while (current.getNext() != null) {
        if (current.getKey().equals(key)) {
          current.setValue(value);
          return;
        }
        current = current.getNext();
      }
      current.setNext(new Entry<>(key, value));
    }
  }

  @Override
  public V get(K key) {
    Entry<K, V> current = head;
    while (current != null) {
      if (current.getKey().equals(key)) {
        return current.getValue();
      }
      current = current.getNext();
    }
    throw new RuntimeException("key not found");
  }

  @Override
  public boolean find(K key) {
    try {
      return get(key) != null;
    } catch (RuntimeException e) {
      return false;
    }
  }

  @Override
  public void remove(K key) {
    Entry<K, V> current = head, previous = null;
    while (current != null) {
      if (current.getKey().equals(key)) {
        if (previous == null) {
          head = current.getNext();
        } else {
          previous.setNext(current.getNext());
        }
        return;
      }
      previous = current;
      current = current.getNext();
    }
    throw new RuntimeException("key not found");
  }
}
