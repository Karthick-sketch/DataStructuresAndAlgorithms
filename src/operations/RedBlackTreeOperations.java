package operations;

import datastructures.nonlinear.tree.binarytree.RedBlackTree;
import java.util.Arrays;

public class RedBlackTreeOperations {

  public static void operations() {
    int[] values = { 5, 6, 7, 4, 8, 2, 9, 3, 1 };
    RedBlackTree rbt = new RedBlackTree(values);
    System.out.println("Array:          " + Arrays.toString(values));
    System.out.println("Red-Black Tree: " + rbt.get());
  }
}
