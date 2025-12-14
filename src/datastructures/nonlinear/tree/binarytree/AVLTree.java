package datastructures.nonlinear.tree.binarytree;

public class AVLTree extends BinarySearchTree {

  public AVLTree() {
    super();
  }

  public AVLTree(int[] values) {
    super();
    insert(values);
  }

  @Override
  public void insert(int[] values) {
    for (int value : values) {
      insert(value);
    }
  }

  @Override
  public void insert(int value) {
    super.insert(value);
    selfBalance(root);
  }

  private void selfBalance(BinaryTreeNode<Integer> node) {
    if (node == null) {
      return;
    }
    selfBalance(node.getLeft());
    selfBalance(node.getRight());
    int bf = balanceFactor(node);
    if (bf > 1) {
      BinaryTreeNode<Integer> left = node.getLeft();
      node.setLeft(left.getRight());
      left.setRight(node);
      if (node == root) {
        root = left;
      }
    } else if (bf < -1) {
      BinaryTreeNode<Integer> right = node.getRight();
      node.setRight(right.getLeft());
      right.setLeft(node);
      if (node == root) {
        root = right;
      }
    }
  }

  private int balanceFactor(BinaryTreeNode<Integer> node) {
    if (node == null) {
      return 0;
    } else {
      return findHeight(node.getLeft()) - findHeight(node.getRight());
    }
  }
}
