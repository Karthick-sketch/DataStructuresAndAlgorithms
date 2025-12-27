package datastructures.linear.linkedlist;

public interface LinkedList<L> {
  int size();
  L get(int index);
  void add(L value);
  void addAll(L[] values);
  void insert(L value, int index);
  void update(L value, int index);
  L remove(int index);
  L remove(L value);
  void clear();
}
