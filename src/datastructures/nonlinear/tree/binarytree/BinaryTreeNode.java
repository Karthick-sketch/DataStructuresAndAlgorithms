package datastructures.nonlinear.tree.binarytree;

class BinaryTreeNode<B> {

  private B value;
  private BinaryTreeNode<B> left;
  private BinaryTreeNode<B> right;

  BinaryTreeNode(B value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  void setValue(B value) {
    this.value = value;
  }

  B getValue() {
    return value;
  }

  void setLeft(BinaryTreeNode<B> left) {
    this.left = left;
  }

  BinaryTreeNode<B> getLeft() {
    return left;
  }

  void setRight(BinaryTreeNode<B> right) {
    this.right = right;
  }

  BinaryTreeNode<B> getRight() {
    return right;
  }
}
