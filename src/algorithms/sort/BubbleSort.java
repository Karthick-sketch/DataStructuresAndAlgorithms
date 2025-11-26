package algorithms.sort;

public class BubbleSort implements Sort {
  @Override
  public void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < array.length - i; j++) {
        if (array[j] > array[j + 1]) {
          int v = array[j];
          array[j] = array[j + 1];
          array[j + 1] = v;
        }
      }
    }
  }
}
