package datastructures.nonlinear.hash;

import datastructures.linear.list.ArrayList;
import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

public class LinkedMap<K, V> implements Map<K, V> {

  private List<Entry<K, V>> list = new LinkedList<>();

  @Override
  public void put(K key, V value) {
    Entry<K, V> entry = fetch(key);
    if (entry != null) {
      entry.setValue(value);
    } else {
      list.add(new Entry<>(key, value));
    }
  }

  private Entry<K, V> fetch(K key) {
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
    for (int i = 0; i < list.size(); i++) {
      Entry<K, V> entry = list.get(i);
      keys.add(entry.getKey());
    }
    return keys;
  }

  @Override
  public List<V> getValues() {
    List<V> values = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      Entry<K, V> entry = list.get(i);
      values.add(entry.getValue());
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
    list.remove(entry);
    return entry.getValue();
  }

  @Override
  public void clear() {
    list.clear();
  }
}
