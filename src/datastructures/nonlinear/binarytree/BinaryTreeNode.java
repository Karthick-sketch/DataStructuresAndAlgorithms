package datastructures.nonlinear.binarytree;

public class BinaryTreeNode {

  private int value;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  public BinaryTreeNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setLeft(BinaryTreeNode left) {
    this.left = left;
  }

  public BinaryTreeNode getLeft() {
    return left;
  }

  public void setRight(BinaryTreeNode right) {
    this.right = right;
  }

  public BinaryTreeNode getRight() {
    return right;
  }
}
