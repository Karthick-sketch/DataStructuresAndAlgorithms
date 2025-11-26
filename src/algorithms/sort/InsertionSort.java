package algorithms.sort;

public class InsertionSort implements Sort {
  @Override
  public void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int temp = array[i];
      int j = i - 1;
      for (; j >= 0 && array[j] > temp; j--) {
        array[j + 1] = array[j];
      }
      array[j + 1] = temp;
    }
  }
}
