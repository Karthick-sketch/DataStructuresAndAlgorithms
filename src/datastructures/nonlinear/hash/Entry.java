package datastructures.nonlinear.hash;

class Entry<K, V> {

  private K key;
  private V value;

  Entry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  K getKey() {
    return key;
  }

  void setKey(K key) {
    this.key = key;
  }

  V getValue() {
    return value;
  }

  void setValue(V value) {
    this.value = value;
  }
}
