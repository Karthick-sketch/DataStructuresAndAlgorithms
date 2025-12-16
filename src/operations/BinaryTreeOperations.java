package operations;

import datastructures.nonlinear.tree.binarytree.BinaryTree;
import java.util.Arrays;

public class BinaryTreeOperations {

  public static void operations() {
    BinaryTree<Integer> bt = new BinaryTree<>();
    int[] values = Randomize.randomizeArray(12);
    for (int value : values) {
      bt.insert(value);
    }
    System.out.println("Array: " + Arrays.toString(values));
    System.out.print("Binary Tree: ");
    bt.print();
  }
}
