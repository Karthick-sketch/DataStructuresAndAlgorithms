package datastructures.nonlinear.tree.binarytree;

abstract class TreeNode<T, TN> {

  private T value;
  private TN left;
  private TN right;

  TreeNode(T value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  void setValue(T value) {
    this.value = value;
  }

  T getValue() {
    return value;
  }

  void setLeft(TN left) {
    this.left = left;
  }

  TN getLeft() {
    return left;
  }

  void setRight(TN right) {
    this.right = right;
  }

  TN getRight() {
    return right;
  }
}
