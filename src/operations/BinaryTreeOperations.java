package operations;

import datastructures.nonlinear.tree.binarytree.BinaryTree;

public class BinaryTreeOperations {

  public static void operations() {
    BinaryTree<Integer> bt = new BinaryTree<>();
    int[] arr = { 4, 2, 6, 1, 3, 5, 7 };
    for (int i = 0; i < arr.length; i++) {
      bt.insert(arr[i]);
    }
    bt.print();
  }
}
