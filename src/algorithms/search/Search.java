package algorithms.search;

public class Search {

  public static int linearSearch(int[] array, int search) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == search) {
        return i;
      }
    }
    return -1;
  }

  public static int jumpSearch(int[] array, int search) {
    int len = array.length;
    int jump = (int) Math.sqrt(len);
    int prev = 0, next = 0;
    while (prev < len) {
      next = Math.min(next + jump, len - 1);
      if (search <= array[next]) {
        for (; prev <= next; prev++) {
          if (array[prev] == search) {
            return prev;
          }
        }
        break;
      }
      prev = next + 1;
    }
    return -1;
  }

  public static int binarySearch(int[] array, int search) {
    int left = 0, right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (search == array[mid]) {
        return mid;
      } else if (search < array[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
