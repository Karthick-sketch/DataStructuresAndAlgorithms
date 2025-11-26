package operations;

import datastructures.nonlinear.binarytree.binarysearchtree.BinarySearchTree;

public class TreeOperations {
  public static void operations() {
    int[] values = { 8, 4, 2, 6, 1, 5, 3, 7, 10, 9, 11 };
    BinarySearchTree bst = new BinarySearchTree(values);

    System.out.println("Iterative : " + bst.get());
    System.out.println("In-order : " + bst.getInOrder());
    System.out.println("Pre-order : " + bst.getPreOrder());
    System.out.println("Post-order : " + bst.getPostOrder());

    System.out.println("Search 5 : " + bst.search(5));
    System.out.println("Delete 8 : " + bst.delete(8));
    System.out.println(bst.get());

    System.out.println("Maximum : " + bst.maximum());
    System.out.println("Minimum : " + bst.minimum());

    bst.clear();
    System.out.println(bst.get());
  }
}
