package datastructures.nonlinear.tree.binarytree;

class RedBlackTreeNode extends TreeNode<Integer, RedBlackTreeNode> {

  private boolean red;

  RedBlackTreeNode(int value) {
    super(value);
    this.red = true;
  }

  void setRed(boolean red) {
    this.red = red;
  }

  boolean isRed() {
    return red;
  }
}
