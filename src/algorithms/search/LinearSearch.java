package algorithms.search;

public class LinearSearch implements Search {
  @Override
  public int search(int[] array, int value) {
    for (int index = 0; index < array.length; index++) {
      if (array[index] == value) {
        return index;
      }
    }
    return -1;
  }
}
