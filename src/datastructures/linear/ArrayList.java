package datastructures.linear;

public class ArrayList<T> {

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
  public T get(int index) {
    validateIndex(index);
    return (T) array[index];
  }

  public void add(T value) {
    array[position] = (Object) value;
    position++;
    if (position + 1 >= length) {
      extend();
    }
  }

  public void set(T value, int index) {
    validateIndex(index);
    array[index] = value;
  }

  public void insert(T value, int index) {
    for (int i = position; i > index; i--) {
      array[i] = array[i - 1];
    }
    array[index] = value;
  }

  @SuppressWarnings("unchecked")
  public T remove(int index) {
    validateIndex(index);
    T value = (T) array[index];
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

  public T remove(T value) {
    int index = -1;
    for (int i = 0; i < position; i++) {
      if (array[i].equals(value)) {
        index = i;
        break;
      }
    }
    return remove(index);
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
