package datastructures.nonlinear.tree.binarytree;

public class RedBlackTree extends AVLTree {

  public RedBlackTree() {
    super();
  }

  public RedBlackTree(int[] values) {
    super();
    add(values);
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
  public void add(int[] values) {
    for (int value : values) {
      add(value);
    }
  }

  @Override
  public void add(int value) {
    add(new RedBlackTreeNode(value));
    selfBalance();
  }

  @Override
  public boolean remove(int value) {
    boolean result = removeBST(value);
    if (result) {
      selfBalanceDeletion(getRoot(), null);
      selfBalance();
    }
    return result;
  }

  private void selfBalanceDeletion(
    RedBlackTreeNode node,
    RedBlackTreeNode parent
  ) {
    if (node == null) {
      return;
    }
    boolean adjusted = false;
    RedBlackTreeNode left = getLeft(node);
    RedBlackTreeNode right = getRight(node);
    int bleft = countBlackNodes(left);
    int bright = countBlackNodes(right);
    if (bleft < bright) {
      if (left != null && left.isRed()) {
        left.setRed(false);
      } else {
        rotationRR(right, node);
        linkNodes(node, parent, right);
        color(right, false);
      }
      adjusted = true;
    } else if (bleft > bright) {
      if (right != null && right.isRed()) {
        right.setRed(false);
      } else {
        rotationLL(left, node);
        linkNodes(node, parent, left);
        color(left, false);
      }
      adjusted = true;
    }
    if (adjusted) {
      selfBalanceDeletion(getRoot(), null);
    } else {
      selfBalanceDeletion(left, node);
      selfBalanceDeletion(right, node);
    }
  }

  private void selfBalance() {
    selfBalance(getRoot(), null, null, null);
    colorRootBlack();
    if (!validateBlackNodes(getRoot())) {
      throw new RuntimeException("Double black");
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
    if (node.getLeft() != null) {
      getLeft(node).setRed(!isRecolor);
    }
    if (node.getRight() != null) {
      getRight(node).setRed(!isRecolor);
    }
    colorRootBlack();
  }

  private void colorRootBlack() {
    RedBlackTreeNode root = getRoot();
    if (root != null && root.isRed()) {
      root.setRed(false);
    }
  }

  private boolean validateBlackNodes(RedBlackTreeNode node) {
    return (
      node == null ||
      (countBlackNodes(getLeft(node)) == countBlackNodes(getRight(node)))
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
