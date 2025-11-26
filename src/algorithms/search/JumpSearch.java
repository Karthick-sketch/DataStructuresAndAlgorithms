package algorithms.search;

public class JumpSearch implements Search {
  @Override
  public int search(int[] array, int value) {
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
}
