package datastructures.nonlinear.hash;

import datastructures.linear.list.List;

public interface Map<K, V> {
  void put(K key, V value);
  V get(K key);
  List<K> getKeys();
  List<V> getValues();
  boolean find(K key);
  V remove(K key);
  void clear();
}
