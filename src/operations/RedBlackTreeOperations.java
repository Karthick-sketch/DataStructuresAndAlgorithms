package operations;

import datastructures.nonlinear.tree.binarytree.RedBlackTree;
import java.util.Arrays;

public class RedBlackTreeOperations {

  public static void operations() {
    int[] values = { 10, 20, 30, 50, 40, 60, 70, 80, 4, 8 };
    RedBlackTree rbt = new RedBlackTree(values);
    System.out.println("Array:          " + Arrays.toString(values));
    System.out.println("Red-Black Tree: " + rbt.get());
  }
}
