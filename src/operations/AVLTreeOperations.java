package operations;

import datastructures.nonlinear.tree.binarytree.AVLTree;
import java.util.Arrays;

public class AVLTreeOperations {

  public static void operations() {
    int[] values = Randomize.randomizeArray(12);

    AVLTree avl = new AVLTree(values);
    System.out.println("Array:      " + Arrays.toString(values));

    System.out.println("Iterative:  " + avl.get());
    System.out.println("In-order:   " + avl.getInOrder());
    System.out.println("Pre-order:  " + avl.getPreOrder());
    System.out.println("Post-order: " + avl.getPostOrder());

    System.out.printf("Search %d: %b\n", values[5], avl.search(values[5]));
    System.out.printf("Delete %d: %b\n", values[8], avl.delete(values[8]));
    System.out.println(avl.get());

    System.out.println("Maximum: " + avl.maximum());
    System.out.println("Minimum: " + avl.minimum());
    System.out.println("Max Height: " + avl.findMaxHeight());
    System.out.println("Min Height: " + avl.findMinHeight());

    avl.clear();
    System.out.println(avl.get());
  }
}
