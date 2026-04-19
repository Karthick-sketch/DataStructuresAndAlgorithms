package datastructures.nonlinear.hash;

import datastructures.linear.list.ArrayList;
import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

public class HashTable<K, V> implements Map<K, V> {

  private final ArrayList<List<Entry<K, V>>> hashTable;
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

  @Override
  public int size() {
    return elements;
  }

  @Override
  public void put(K key, V value) {
    Entry<K, V> entry = fetch(key);
    if (entry != null) {
      entry.setValue(value);
    } else {
      List<Entry<K, V>> list = getList(key);
      list.add(new Entry<>(key, value));
      elements++;
      checkRehash();
    }
  }

  private List<Entry<K, V>> getList(K key) {
    return hashTable.get(hashFunction(key));
  }

  private Entry<K, V> fetch(K key) {
    List<Entry<K, V>> list = getList(key);
    for (int i = 0; i < list.size(); i++) {
      Entry<K, V> entry = list.get(i);
      if (entry.getKey().equals(key)) {
        return entry;
      }
    }
    return null;
  }

  @Override
  public V get(K key) {
    Entry<K, V> entry = fetch(key);
    if (entry == null) {
      throw new RuntimeException("key not found");
    }
    return entry.getValue();
  }

  @Override
  public List<K> getKeys() {
    List<K> keys = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      hashTable.get(i).forEach(entry -> keys.add(entry.getKey()));
    }
    return keys;
  }

  @Override
  public List<V> getValues() {
    List<V> values = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      hashTable.get(i).forEach(entry -> values.add(entry.getValue()));
    }
    return values;
  }

  @Override
  public boolean find(K key) {
    return fetch(key) != null;
  }

  @Override
  public V remove(K key) {
    Entry<K, V> entry = fetch(key);
    if (entry == null) {
      throw new RuntimeException("key not found");
    }
    List<Entry<K, V>> list = getList(key);
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

  private int hashFunction(K key) {
    return compressionMap(hashCode(key));
  }

  private int hashCode(Object key) {
    if (key == null) return 0;

    if (key instanceof Byte b) {
      return b;
    } else if (key instanceof Short s) {
      return s;
    } else if (key instanceof Integer i) {
      return i;
    } else if (key instanceof Character c) {
      return c;
    } else if (key instanceof Long l) {
      return (int) (l ^ (l >>> 32));
    } else if (key instanceof Float f) {
      return Float.floatToIntBits(f);
    } else if (key instanceof Double d) {
      long bits = Double.doubleToLongBits(d);
      return (int) (bits ^ (bits >>> 32));
    } else if (key instanceof Boolean b) {
      return b ? 1 : 0;
    } else if (key instanceof String s) {
      int code = 0;
      for (char c : s.toCharArray()) {
        code = ((code << 5) - code) + c;
      }
      return code;
    } else {
      return key.hashCode();
    }
  }

  private int compressionMap(int code) {
    return (code & Integer.MAX_VALUE) % length;
  }

  private float loadFactor() {
    return (float) elements / length;
  }

  private void checkRehash() {
    if (loadFactor() >= 1.0f) {
      rehash();
    }
  }

  private void rehash() {
    List<Entry<K, V>> entries = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      hashTable.get(i).forEach(entry -> entries.add(entry));
    }
    clear(nearestPrimeNumber(length * 2));
    entries.forEach(entry -> put(entry.getKey(), entry.getValue()));
  }

  private int nearestPrimeNumber(int seed) {
    if (seed <= 2) return 2;

    // Make seed odd (except 2)
    if (seed % 2 == 0) seed++;

    for (int offset = 0;; offset += 2) {
      int higher = seed + offset;
      int lower = seed - offset;

      if (isPrimeNumber(higher)) {
        return higher;
      }
      if (lower >= 3 && isPrimeNumber(lower)) {
        return lower;
      }
    }
  }

  private boolean isPrimeNumber(int number) {
    if (number < 2) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;

    for (int i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
