package datastructures.linear.list;

import java.util.function.Consumer;

public interface List<L> {
  int size();
  L get(int index);
  void add(L value);
  void addAll(L[] values);
  void set(L value, int index);
  void insert(L value, int index);
  L remove(int index);
  L remove(L value);
  void clear();
  boolean isEmpty();
  void forEach(Consumer<L> action);
}
