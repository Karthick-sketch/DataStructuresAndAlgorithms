package datastructures.linear.list;

public class ArrayList<L> implements List<L> {

  private final int RANGE = 10;
  private Object[] array;
  private int length = RANGE;
  private int position = 0;

  public ArrayList() {
    array = new Object[length];
  }

  public int size() {
    return position;
  }

  public boolean isEmpty() {
    return position == 0;
  }

  @SuppressWarnings("unchecked")
  public L get(int index) {
    validateIndex(index);
    return (L) array[index];
  }

  public void add(L value) {
    array[position] = (Object) value;
    position++;
    if (position + 1 >= length) {
      extend();
    }
  }

  @Override
  public void addAll(L[] values) {
    for (L value : values) {
      add(value);
    }
  }

  public void set(L value, int index) {
    validateIndex(index);
    array[index] = value;
  }

  public void insert(L value, int index) {
    for (int i = position; i > index; i--) {
      array[i] = array[i - 1];
    }
    array[index] = value;
    position++;
  }

  @SuppressWarnings("unchecked")
  public L remove(int index) {
    validateIndex(index);
    L value = (L) array[index];
    for (int i = index; i < position; i++) {
      array[i] = array[i + 1];
    }
    array[position] = null;
    position--;
    if (position > RANGE && position < length - RANGE) {
      shrink();
    }
    return value;
  }

  public L remove(L value) {
    int index = -1;
    for (int i = 0; i < position; i++) {
      if (array[i].equals(value)) {
        index = i;
        break;
      }
    }
    return remove(index);
  }

  @Override
  public void clear() {
    position = 0;
    length = RANGE;
    array = new Object[length];
  }

  @Override
  public String toString() {
    if (position == 0) {
      return "[]";
    }
    StringBuilder values = new StringBuilder("[");
    for (int i = 0; i < position - 1; i++) {
      values.append(array[i]).append(", ");
    }
    return values.toString() + array[position - 1] + "]";
  }

  private void validateIndex(int index) {
    if (index < 0 && index >= position) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void extend() {
    length += RANGE;
    adjust();
  }

  private void shrink() {
    length -= RANGE;
    adjust();
  }

  private void adjust() {
    Object[] objects = new Object[length];
    for (int i = 0; i < position; i++) {
      objects[i] = array[i];
    }
    array = objects;
  }
}
