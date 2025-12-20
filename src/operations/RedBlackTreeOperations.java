package operations;

import datastructures.nonlinear.tree.binarytree.RedBlackTree;
import java.util.Arrays;

public class RedBlackTreeOperations {

  public static void operations() {
    // int[] values = Randomize.randomizeArray(15);
    int[] values = {
      85,
      33,
      47,
      48,
      81,
      71,
      19,
      14,
      24,
      30,
      57,
      99,
      98,
      25,
      93,
    };

    // 85, 33, 47, 48, 81, 71, 19, 14, 24, 30, 57, 99, 98, 25, 93
    RedBlackTree rbt = new RedBlackTree(values);
    System.out.println("Array:          " + Arrays.toString(values));
    System.out.println("Red-Black Tree: " + rbt.get());
    // delete 24
    System.out.printf("Delete %d: %b\n", 24, rbt.delete(24));
    System.out.println("Red-Black Tree: " + rbt.get());
  }
}
