package datastructures.nonlinear.tree.binarytree;

public class RedBlackTree extends AVLTree {

  public RedBlackTree() {
    super();
  }

  public RedBlackTree(int[] values) {
    super();
    insert(values);
  }

  private RedBlackTreeNode getRoot() {
    return (RedBlackTreeNode) super.root;
  }

  private RedBlackTreeNode getLeft(BinaryTreeNode<Integer> node) {
    return (RedBlackTreeNode) node.getLeft();
  }

  private RedBlackTreeNode getRight(BinaryTreeNode<Integer> node) {
    return (RedBlackTreeNode) node.getRight();
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
    selfBalance();
  }

  @Override
  public boolean delete(int value) {
    RedBlackTreeNode child = getRoot(), parent = null, grand = null;
    while (child != null) {
      if (value == child.getValue()) {
        if (child.getLeft() != null && child.getRight() != null) {
          RedBlackTreeNode current = child;
          grand = parent;
          parent = child;
          child = getLeft(child);
          while (child.getRight() != null) {
            grand = parent;
            parent = child;
            child = getRight(child);
          }
          swapValue(current, child);
        }
        if (child.isRed()) {
          super.delete(child, parent);
        } else {
          deleteBlackNode(child, parent, grand);
        }
        return true;
      } else {
        grand = parent;
        parent = child;
        child = value < child.getValue() ? getLeft(child) : getRight(child);
      }
    }
    return false;
  }

  private void deleteBlackNode(
    RedBlackTreeNode child,
    RedBlackTreeNode parent,
    RedBlackTreeNode grand
  ) {
    RedBlackTreeNode current = getLeft(child);
    if (current != null && current.isRed()) {
      swapValue(current, child);
      super.delete(current, child);
    } else {
      RedBlackTreeNode sibling = getChild(parent, p -> p.getLeft() != child);
      if (sibling.isRed()) {}
    }
  }

  private void selfBalance() {
    selfBalance(getRoot(), null, null, null);
    colorRootBlack();
    if (!validateBlackNodes()) {
      throw new RuntimeException("Black nodes mismatch");
    }
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
    boolean adjusted = false;
    if (grand != null && parent.isRed() && child.isRed()) {
      if (grand.getLeft() == parent) {
        RedBlackTreeNode gRight = getRight(grand);
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
        RedBlackTreeNode gLeft = getLeft(grand);
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
        adjusted = true;
      }
    }
    if (adjusted) {
      selfBalance();
    } else {
      selfBalance(getLeft(child), child, parent, grand);
      selfBalance(getRight(child), child, parent, grand);
    }
  }

  private void color(RedBlackTreeNode node, boolean isRecolor) {
    node.setRed(isRecolor);
    getLeft(node).setRed(!isRecolor);
    getRight(node).setRed(!isRecolor);
    colorRootBlack();
  }

  private void colorRootBlack() {
    RedBlackTreeNode root = getRoot();
    if (root.isRed()) {
      root.setRed(false);
    }
  }

  private boolean validateBlackNodes() {
    RedBlackTreeNode root = getRoot();
    return (
      root == null ||
      (countBlackNodes(getLeft(root)) == countBlackNodes(getRight(root)))
    );
  }

  private int countBlackNodes(RedBlackTreeNode node) {
    if (node == null) {
      return 1;
    } else {
      int lb = countBlackNodes(getLeft(node));
      int rb = countBlackNodes(getRight(node));
      return Math.min(lb, rb) + (node.isRed() ? 0 : 1);
    }
  }
}
