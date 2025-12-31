package datastructures.nonlinear.hash;

import datastructures.linear.list.ArrayList;
import datastructures.linear.list.List;

public class LinkedMap<K, V> implements Map<K, V> {

  private Entry<K, V> head;

  @Override
  public void put(K key, V value) {
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

  private V fetch(K key) {
    Entry<K, V> current = head;
    while (current != null) {
      if (current.getKey().equals(key)) {
        return current.getValue();
      }
      current = current.getNext();
    }
    return null;
  }

  @Override
  public V get(K key) {
    V value = fetch(key);
    if (value == null) {
      throw new RuntimeException("key not found");
    }
    return value;
  }

  @Override
  public List<K> getKeys() {
    List<K> keys = new ArrayList<>();
    Entry<K, V> entry = head;
    while (entry != null) {
      keys.add(entry.getKey());
      entry = entry.getNext();
    }
    return keys;
  }

  @Override
  public List<V> getValues() {
    List<V> values = new ArrayList<>();
    Entry<K, V> entry = head;
    while (entry != null) {
      values.add(entry.getValue());
      entry = entry.getNext();
    }
    return values;
  }

  @Override
  public boolean find(K key) {
    return fetch(key) != null;
  }

  @Override
  public V remove(K key) {
    Entry<K, V> current = head, previous = null;
    while (current != null) {
      if (current.getKey().equals(key)) {
        if (previous == null) {
          head = current.getNext();
        } else {
          previous.setNext(current.getNext());
        }
        return current.getValue();
      }
      previous = current;
      current = current.getNext();
    }
    throw new RuntimeException("key not found");
  }
}
