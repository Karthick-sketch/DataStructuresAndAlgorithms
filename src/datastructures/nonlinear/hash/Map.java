package datastructures.nonlinear.hash;

public interface Map<K, V> {
  void put(K key, V value);
  V get(K key);
  boolean find(K key);
  void remove(K key);
}
