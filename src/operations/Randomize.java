package operations;

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
}
