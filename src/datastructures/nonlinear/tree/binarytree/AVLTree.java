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
    selfBalance(root, null);
  }

  @Override
  public boolean delete(int value) {
    boolean result = super.delete(value);
    if (result) {
      selfBalance(root, null);
    }
    return result;
  }

  // [95, 84, 38, 99, 3, 86, 30, 57, 76, 52]
  private void selfBalance(
    BinaryTreeNode<Integer> node,
    BinaryTreeNode<Integer> parent
  ) {
    if (node == null) {
      return;
    }
    selfBalance(node.getLeft(), node);
    selfBalance(node.getRight(), node);
    int bf = balanceFactor(node);
    if (bf > 1) {
      BinaryTreeNode<Integer> left = node.getLeft();
      // LR rotation
      if (balanceFactor(left) == -1) {
        BinaryTreeNode<Integer> lRight = left.getRight();
        node.setLeft(lRight);
        left.setRight(lRight.getLeft());
        lRight.setLeft(left);
        left = node.getLeft();
      }
      // LL rotation
      node.setLeft(left.getRight());
      left.setRight(node);
      if (node == root) {
        root = left;
      } else if (parent.getLeft() == node) {
        parent.setLeft(left);
      } else {
        parent.setRight(left);
      }
    } else if (bf < -1) {
      BinaryTreeNode<Integer> right = node.getRight();
      // RL rotation
      if (balanceFactor(right) == 1) {
        BinaryTreeNode<Integer> rLeft = right.getLeft();
        node.setRight(rLeft);
        right.setLeft(rLeft.getRight());
        rLeft.setRight(right);
        right = node.getRight();
      }
      // RR rotation
      node.setRight(right.getLeft());
      right.setLeft(node);
      if (node == root) {
        root = right;
      } else if (parent.getLeft() == node) {
        parent.setLeft(right);
      } else {
        parent.setRight(right);
      }
    }
  }

  private int balanceFactor(BinaryTreeNode<Integer> node) {
    return findMaxHeight(node.getLeft()) - findMaxHeight(node.getRight());
  }
}
