package datastructures.nonlinear.hash;

import datastructures.linear.list.ArrayList;
import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

public class HashTable<V> implements Map<Integer, V> {

  private final ArrayList<List<Entry<Integer, V>>> hashTable;
  private final int RANGE = 11;

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
      List<Entry<Integer, V>> list = getList(key);
      list.add(new Entry<>(key, value));
      elements++;
      checkRehash();
    }
  }

  private List<Entry<Integer, V>> getList(Integer key) {
    return hashTable.get(hashFunction(key));
  }

  private Entry<Integer, V> fetch(Integer key) {
    List<Entry<Integer, V>> list = getList(key);
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
    List<Entry<Integer, V>> list = getList(key);
    list.remove(entry);
    elements--;
    return entry.getValue();
  }

  @Override
  public void clear() {
    clear(RANGE);
  }

  private void clear(int length) {
    this.length = length;
    elements = 0;
    hashTable.clear();
    setHashTable();
  }

  private int hashFunction(Integer key) {
    return compressionMap(hashCode(key));
  }

  private int hashCode(Integer key) {
    return key;
  }

  private int compressionMap(Integer code) {
    return code % length;
  }

  private float loadFactor() {
    return (float) elements / length;
  }

  private void checkRehash() {
    if (loadFactor() > 1.0f) {
      rehash();
    }
  }

  private void rehash() {
    List<Entry<Integer, V>> entries = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      List<Entry<Integer, V>> list = hashTable.get(i);
      for (int j = 0; j < list.size(); j++) {
        entries.add(list.get(j));
      }
    }
    clear(nearestPrimeNumber(length));
    for (int i = 0; i < entries.size(); i++) {
      Entry<Integer, V> entry = entries.get(i);
      put(entry.getKey(), entry.getValue());
    }
  }

  private int nearestPrimeNumber(int seed) {
    int len = seed * 2;
    for (int i = len, j = len; j > seed; i++, j--) {
      if (isPrimeNumber(i)) {
        return i;
      } else if (isPrimeNumber(j)) {
        return j;
      }
    }
    return len;
  }

  private boolean isPrimeNumber(int number) {
    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
