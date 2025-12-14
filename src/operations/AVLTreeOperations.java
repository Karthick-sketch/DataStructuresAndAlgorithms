package operations;

import datastructures.nonlinear.tree.binarytree.AVLTree;

public class AVLTreeOperations {

  public static void operations() {
    AVLTree bt = new AVLTree();
    int[] arr = { 5, 6, 7, 4, 8, 2, 9 };
    bt.insert(arr);
    System.out.println(bt.get().toString());
  }
}
