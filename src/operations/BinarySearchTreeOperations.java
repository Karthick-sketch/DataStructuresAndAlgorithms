package operations;

import datastructures.nonlinear.tree.binarytree.BinarySearchTree;
import java.util.Arrays;

public class BinarySearchTreeOperations {

  public static void operations() {
    int[] values = Randomize.randomizeArray(12);
    BinarySearchTree bst = new BinarySearchTree(values);

    System.out.println("Array: " + Arrays.toString(values));
    System.out.println("Iterative: " + bst.get());
    System.out.println("In-order: " + bst.getInOrder());
    System.out.println("Pre-order: " + bst.getPreOrder());
    System.out.println("Post-order: " + bst.getPostOrder());

    System.out.printf("Search %d: %b\n", values[5], bst.search(values[5]));
    System.out.printf("Delete %d: %b\n", values[8], bst.delete(values[8]));
    System.out.println(bst.get());

    System.out.println("Maximum: " + bst.maximum());
    System.out.println("Minimum: " + bst.minimum());
    System.out.println("Max Height: " + bst.findMaxHeight());
    System.out.println("Min Height: " + bst.findMinHeight());

    bst.clear();
    System.out.println(bst.get());
  }
}
