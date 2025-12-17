package operations;

import datastructures.nonlinear.tree.binarytree.BinaryTree;
import java.util.Arrays;

public class BinaryTreeOperations {

  public static void operations() {
    Integer[] values = Randomize.randomizeIntegerArray(12);
    BinaryTree<Integer> bst = new BinaryTree<>(values);

    System.out.println("Array: " + Arrays.toString(values));
    System.out.println("Iterative: " + bst.get());
    System.out.println("In-order: " + bst.getInOrder());
    System.out.println("Pre-order: " + bst.getPreOrder());
    System.out.println("Post-order: " + bst.getPostOrder());

    System.out.println("Max Height: " + bst.findMaxHeight());
    System.out.println("Min Height: " + bst.findMinHeight());

    bst.clear();
    System.out.println(bst.get());
  }
}
