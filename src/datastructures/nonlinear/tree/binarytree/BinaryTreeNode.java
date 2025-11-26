package datastructures.nonlinear.tree.binarytree;

public class BinaryTreeNode<BT> {
  private BT value;
  private BinaryTreeNode<BT> left;
  private BinaryTreeNode<BT> right;

  public BinaryTreeNode(BT value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public void setValue(BT value) {
    this.value = value;
  }

  public BT getValue() {
    return value;
  }

  public void setLeft(BinaryTreeNode<BT> left) {
    this.left = left;
  }

  public BinaryTreeNode<BT> getLeft() {
    return left;
  }

  public void setRight(BinaryTreeNode<BT> right) {
    this.right = right;
  }

  public BinaryTreeNode<BT> getRight() {
    return right;
  }
}
