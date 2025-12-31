package datastructures.nonlinear.hash;

import datastructures.linear.list.ArrayList;
import datastructures.linear.list.List;

public class HashTable<V> implements Map<Integer, V> {

  private final int RANGE = 11;
  private final ArrayList<Entry<Integer, V>> hashTable;
  private int length = RANGE;
  private int elements = 0;

  public HashTable() {
    hashTable = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      hashTable.add(null);
    }
  }

  public int size() {
    return elements;
  }

  @Override
  public void put(Integer key, V value) {
    Entry<Integer, V> entry = new Entry<>(key, value);
    int index = hashDivision(key);
    Entry<Integer, V> current = hashTable.get(index);
    if (current == null) {
      hashTable.set(entry, index);
    } else {
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(entry);
    }
    elements++;
    checkRehash();
  }

  private V fetch(Integer key) {
    int index = hashDivision(key);
    Entry<Integer, V> current = hashTable.get(index);
    while (current != null) {
      if (current.getKey().equals(key)) {
        return current.getValue();
      }
      current = current.getNext();
    }
    return null;
  }

  @Override
  public V get(Integer key) {
    V value = fetch(key);
    if (value == null) {
      throw new RuntimeException("key not found");
    }
    return value;
  }

  @Override
  public List<Integer> getKeys() {
    List<Integer> keys = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      Entry<Integer, V> entry = hashTable.get(i);
      if (entry != null) {
        keys.add(entry.getKey());
        entry = entry.getNext();
      }
    }
    return keys;
  }

  @Override
  public List<V> getValues() {
    List<V> values = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      Entry<Integer, V> entry = hashTable.get(i);
      if (entry != null) {
        values.add(entry.getValue());
        entry = entry.getNext();
      }
    }
    return values;
  }

  @Override
  public boolean find(Integer key) {
    return fetch(key) != null;
  }

  @Override
  public V remove(Integer key) {
    int index = hashDivision(key);
    Entry<Integer, V> current = hashTable.get(index), previous = null;
    while (current != null) {
      if (current.getKey().equals(key)) {
        if (previous == null) {
          hashTable.set(current.getNext(), index);
        } else {
          previous.setNext(current.getNext());
        }
        elements--;
        return current.getValue();
      }
      current = current.getNext();
    }
    throw new RuntimeException("key not found");
  }

  private int hashDivision(Integer key) {
    return key % length;
  }

  private void checkRehash() {
    if (loadFactor() > 0.7) {
      rehash();
    }
  }

  private double loadFactor() {
    return elements / length;
  }

  private void rehash() {
    List<Entry<Integer, V>> entries = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      Entry<Integer, V> entry = hashTable.get(i);
      if (entry != null) {
        entries.add(entry);
        entry = entry.getNext();
      }
    }
    hashTable.clear();
    length += RANGE;
    for (int i = 0; i < entries.size(); i++) {
      Entry<Integer, V> entry = entries.get(i);
      put(entry.getKey(), entry.getValue());
    }
  }
}
