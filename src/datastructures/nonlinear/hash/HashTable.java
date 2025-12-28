package datastructures.nonlinear.hash;

import java.util.ArrayList;

public class HashTable<V> implements Map<Integer, V> {

  private final int length;
  private final ArrayList<Entry<Integer, V>> hashTable;

  public HashTable() {
    this(10);
  }

  public HashTable(int length) {
    this.length = length;
    hashTable = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      hashTable.add(null);
    }
  }

  @Override
  public void add(Integer key, V value) {
    Entry<Integer, V> entry = new Entry<>(key, value);
    int index = hashDivision(key);
    Entry<Integer, V> current = hashTable.get(index);
    if (current == null) {
      hashTable.set(index, entry);
    } else {
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(entry);
    }
  }

  @Override
  public V get(Integer key) {
    int index = hashDivision(key);
    Entry<Integer, V> current = hashTable.get(index);
    while (current != null) {
      if (current.getKey().equals(key)) {
        return current.getValue();
      }
      current = current.getNext();
    }
    throw new RuntimeException("key not found");
  }

  @Override
  public boolean find(Integer key) {
    try {
      return get(key) != null;
    } catch (RuntimeException e) {
      return false;
    }
  }

  @Override
  public void remove(Integer key) {
    int index = hashDivision(key);
    Entry<Integer, V> current = hashTable.get(index), previous = null;
    while (current != null) {
      if (current.getKey().equals(key)) {
        if (previous == null) {
          hashTable.set(index, current.getNext());
        } else {
          previous.setNext(current.getNext());
        }
        return;
      }
      current = current.getNext();
    }
    throw new RuntimeException("key not found");
  }

  private int hashDivision(Integer key) {
    return key % length;
  }
}
