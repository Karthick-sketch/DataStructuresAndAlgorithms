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

  protected boolean deleteBST(int value) {
    return super.delete(value);
  }

  @Override
  public boolean delete(int value) {
    boolean result = deleteBST(value);
    if (result) {
      selfBalance(root, null);
    }
    return result;
  }

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
      if (balanceFactor(left) == -1) {
        // LR rotation
        rotationLR(left.getRight(), left, node);
        left = node.getLeft();
      }
      // LL rotation
      rotationLL(left, node);
      linkNodes(node, parent, left);
    } else if (bf < -1) {
      BinaryTreeNode<Integer> right = node.getRight();
      if (balanceFactor(right) == 1) {
        // RL rotation
        rotationRL(right.getLeft(), right, node);
        right = node.getRight();
      }
      // RR rotation
      rotationRR(right, node);
      linkNodes(node, parent, right);
    }
  }

  protected void rotationLR(
    BinaryTreeNode<Integer> child,
    BinaryTreeNode<Integer> parent,
    BinaryTreeNode<Integer> grand
  ) {
    grand.setLeft(child);
    parent.setRight(child.getLeft());
    child.setLeft(parent);
  }

  protected void rotationLL(
    BinaryTreeNode<Integer> child,
    BinaryTreeNode<Integer> parent
  ) {
    parent.setLeft(child.getRight());
    child.setRight(parent);
  }

  protected void rotationRL(
    BinaryTreeNode<Integer> child,
    BinaryTreeNode<Integer> parent,
    BinaryTreeNode<Integer> grand
  ) {
    grand.setRight(child);
    parent.setLeft(child.getRight());
    child.setRight(parent);
  }

  protected void rotationRR(
    BinaryTreeNode<Integer> child,
    BinaryTreeNode<Integer> parent
  ) {
    parent.setRight(child.getLeft());
    child.setLeft(parent);
  }

  protected void linkNodes(
    BinaryTreeNode<Integer> node,
    BinaryTreeNode<Integer> parent,
    BinaryTreeNode<Integer> child
  ) {
    if (node == root) {
      root = child;
    } else if (parent.getLeft() == node) {
      parent.setLeft(child);
    } else {
      parent.setRight(child);
    }
  }

  private int balanceFactor(BinaryTreeNode<Integer> node) {
    return findMaxHeight(node.getLeft()) - findMaxHeight(node.getRight());
  }
}
