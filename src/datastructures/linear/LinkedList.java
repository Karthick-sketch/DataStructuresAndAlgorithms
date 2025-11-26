package datastructures.linear;

public interface LinkedList<L> {
  int size();
  L get(int index);
  void add(L value);
  void insert(L value, int index);
  void update(L value, int index);
  L delete(int index);
}
