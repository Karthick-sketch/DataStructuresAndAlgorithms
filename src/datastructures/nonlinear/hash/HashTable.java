package datastructures.nonlinear.hash;

import datastructures.linear.list.ArrayList;
import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

public class HashTable<V> implements Map<Integer, V> {

  private final int RANGE = 11;
  private final ArrayList<List<Entry<Integer, V>>> hashTable;
  private int length = RANGE;
  private int elements = 0;

  public HashTable() {
    hashTable = new ArrayList<>();
    setHashTable();
  }

  private void setHashTable() {
    for (int i = 0; i < length; i++) {
      hashTable.add(new LinkedList<>());
    }
  }

  public int size() {
    return elements;
  }

  @Override
  public void put(Integer key, V value) {
    Entry<Integer, V> entry = fetch(key);
    if (entry != null) {
      entry.setValue(value);
    } else {
      int index = hashDivision(key);
      List<Entry<Integer, V>> list = hashTable.get(index);
      list.add(new Entry<>(key, value));
      elements++;
      checkRehash();
    }
  }

  private Entry<Integer, V> fetch(Integer key) {
    int index = hashDivision(key);
    List<Entry<Integer, V>> list = hashTable.get(index);
    for (int i = 0; i < list.size(); i++) {
      Entry<Integer, V> entry = list.get(i);
      if (entry.getKey().equals(key)) {
        return entry;
      }
    }
    return null;
  }

  @Override
  public V get(Integer key) {
    Entry<Integer, V> entry = fetch(key);
    if (entry == null) {
      throw new RuntimeException("key not found");
    }
    return entry.getValue();
  }

  @Override
  public List<Integer> getKeys() {
    List<Integer> keys = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      List<Entry<Integer, V>> list = hashTable.get(i);
      for (int j = 0; j < list.size(); j++) {
        keys.add(list.get(j).getKey());
      }
    }
    return keys;
  }

  @Override
  public List<V> getValues() {
    List<V> keys = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      List<Entry<Integer, V>> list = hashTable.get(i);
      for (int j = 0; j < list.size(); j++) {
        keys.add(list.get(j).getValue());
      }
    }
    return keys;
  }

  @Override
  public boolean find(Integer key) {
    return fetch(key) != null;
  }

  @Override
  public V remove(Integer key) {
    Entry<Integer, V> entry = fetch(key);
    if (entry == null) {
      throw new RuntimeException("key not found");
    }
    int index = hashDivision(key);
    List<Entry<Integer, V>> list = hashTable.get(index);
    list.remove(entry);
    elements--;
    return entry.getValue();
  }

  private int hashDivision(Integer key) {
    return key % length;
  }

  private void checkRehash() {
    if (loadFactor() > 0.7f) {
      rehash();
    }
  }

  private float loadFactor() {
    return (float) elements / length;
  }

  private void rehash() {
    List<Entry<Integer, V>> entries = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      List<Entry<Integer, V>> list = hashTable.get(i);
      for (int j = 0; j < list.size(); j++) {
        entries.add(list.get(j));
      }
    }
    elements = 0;
    length += RANGE;
    hashTable.clear();
    setHashTable();
    for (int i = 0; i < entries.size(); i++) {
      Entry<Integer, V> entry = entries.get(i);
      put(entry.getKey(), entry.getValue());
    }
  }
}
