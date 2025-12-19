package datastructures.nonlinear.tree.binarytree;

public class RedBlackTree extends AVLTree {

  public RedBlackTree() {
    super();
  }

  public RedBlackTree(int[] values) {
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
    insert(new RedBlackTreeNode(value));
    selfBalance((RedBlackTreeNode) root, null, null, null);
    setRootBlack();
  }

  private void selfBalance(
    RedBlackTreeNode child,
    RedBlackTreeNode parent,
    RedBlackTreeNode grand,
    RedBlackTreeNode great
  ) {
    if (child == null) {
      return;
    }
    selfBalance((RedBlackTreeNode) child.getLeft(), child, parent, grand);
    selfBalance((RedBlackTreeNode) child.getRight(), child, parent, grand);
    if (grand != null && parent.isRed() && child.isRed()) {
      if (grand.getLeft() == parent) {
        RedBlackTreeNode gRight = (RedBlackTreeNode) grand.getRight();
        if (gRight == null || !gRight.isRed()) {
          if (parent.getRight() == child) {
            // LR rotation
            rotationLR(child, parent, grand);
            parent = child;
          }
          // LL rotation
          rotationLL(parent, grand);
          linkNodes(grand, great, parent);
          color(parent, false);
        } else {
          // recolor
          color(grand, true);
        }
      } else {
        RedBlackTreeNode gLeft = (RedBlackTreeNode) grand.getLeft();
        if (gLeft == null || !gLeft.isRed()) {
          if (parent.getLeft() == child) {
            // RL rotation
            rotationRL(child, parent, grand);
            parent = child;
          }
          // RR rotation
          rotationRR(parent, grand);
          linkNodes(grand, great, parent);
          color(parent, false);
        } else {
          // recolor
          color(grand, true);
        }
      }
    }
  }

  private void color(RedBlackTreeNode node, boolean isRecolor) {
    node.setRed(isRecolor);
    ((RedBlackTreeNode) node.getLeft()).setRed(!isRecolor);
    ((RedBlackTreeNode) node.getRight()).setRed(!isRecolor);
    setRootBlack();
  }

  private void setRootBlack() {
    RedBlackTreeNode root = (RedBlackTreeNode) super.root;
    if (root.isRed()) {
      root.setRed(false);
    }
  }
}
