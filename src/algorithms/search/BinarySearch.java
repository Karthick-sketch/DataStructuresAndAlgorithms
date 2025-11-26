package algorithms.search;

public class BinarySearch implements Search {
  @Override
  public int search(int[] array, int value) {
    int left = 0, right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (value == array[mid]) {
        return mid;
      } else if (value < array[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
