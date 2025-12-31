package algorithms;

public final class Search {

  private Search() {}

  public static int linearSearch(int[] array, int value) {
    for (int index = 0; index < array.length; index++) {
      if (array[index] == value) {
        return index;
      }
    }
    return -1;
  }

  public static int jumpSearch(int[] array, int value) {
    int len = array.length;
    int jump = (int) Math.sqrt(len);
    int prev = 0, next = 0;
    while (prev < len) {
      next = Math.min(next + jump, len - 1);
      if (value <= array[next]) {
        for (; prev <= next; prev++) {
          if (array[prev] == value) {
            return prev;
          }
        }
        break;
      }
      prev = next + 1;
    }
    return -1;
  }

  public static int binarySearch(int[] array, int value) {
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
