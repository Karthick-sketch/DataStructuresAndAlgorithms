package operations;

import java.util.Arrays;
import java.util.Random;

class Randomize {

  static int[] randomizeArray(int length) {
    Random random = new Random();
    int[] array = new int[length];
    for (int i = 0; i < length; i++) {
      array[i] = random.nextInt(100);
    }
    return array;
  }

  static Integer[] randomizeIntegerArray(int length) {
    return toIntegerArray(randomizeArray(length));
  }

  static Integer[] toIntegerArray(int[] array) {
    return Arrays.stream(array).boxed().toArray(Integer[]::new);
  }
}
