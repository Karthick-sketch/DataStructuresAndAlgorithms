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
        delete(child, parent, grand);
        selfBalanceDeletion(getRoot(), null);
        selfBalance();
        return true;
      } else {
        grand = parent;
        parent = child;
        child = value < child.getValue() ? getLeft(child) : getRight(child);
      }
    }
    return false;
  }

  private void delete(
    RedBlackTreeNode child,
    RedBlackTreeNode parent,
    RedBlackTreeNode grand
  ) {
    if (child.getLeft() != null || child.getRight() != null) {
      RedBlackTreeNode current = child;
      grand = parent;
      parent = child;
      if (child.getLeft() != null) {
        // in-order predecessor
        child = getLeft(child);
        while (child.getRight() != null) {
          grand = parent;
          parent = child;
          child = getRight(child);
        }
      } else {
        // in-order successor
        child = getRight(child);
        while (child.getLeft() != null) {
          grand = parent;
          parent = child;
          child = getLeft(child);
        }
      }
      swapValue(current, child);
    }
    if (child.getLeft() == null && child.getRight() == null) {
      if (child.isRed()) {
        super.delete(child, parent);
      } else {
        deleteBlackNode(child, parent, grand);
      }
    } else {
      delete(child, parent, grand);
    }
  }

  private void deleteBlackNode(
    RedBlackTreeNode child,
    RedBlackTreeNode parent,
    RedBlackTreeNode grand
  ) {
    RedBlackTreeNode sibling = getChild(parent, p -> p.getLeft() != child);
    if (parent.getLeft() == child) {
      parent.setLeft(null);
    } else {
      parent.setRight(null);
    }
    if (parent.isRed()) {
      parent.setRed(false);
      sibling.setRed(true);
    } else {
      if (parent.getLeft() == sibling) {
        if (sibling.isRed()) {
          rotationLL(sibling, parent);
          linkNodes(parent, grand, sibling);
          color(sibling, false);
        } else {
          RedBlackTreeNode right = getRight(sibling);
          if (right != null) {
            rotationLR(right, sibling, parent);
            rotationLL(right, parent);
          } else {
            rotationLL(sibling, parent);
            color(sibling, true);
          }
          linkNodes(parent, grand, sibling);
        }
      } else {
        if (sibling.isRed()) {
          rotationRR(sibling, parent);
          linkNodes(parent, grand, sibling);
          color(sibling, false);
        } else {
          RedBlackTreeNode left = getLeft(sibling);
          if (left != null) {
            rotationRL(left, sibling, parent);
            rotationRR(left, parent);
          } else {
            rotationRR(sibling, parent);
            color(sibling, true);
          }
          linkNodes(parent, grand, sibling);
        }
      }
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

  private void selfBalanceDeletion(
    RedBlackTreeNode node,
    RedBlackTreeNode parent
  ) {
    if (node == null) {
      return;
    }
    RedBlackTreeNode left = getLeft(node);
    RedBlackTreeNode right = getRight(node);
    selfBalanceDeletion(left, node);
    selfBalanceDeletion(right, node);
    int bleft = countBlackNodes(left);
    int bright = countBlackNodes(right);
    if (bleft < bright) {
      if (left != null && left.isRed()) {
        left.setRed(false);
      } else {
        rotationRR(right, node);
        color(right, true);
        linkNodes(node, parent, right);
      }
    } else if (bleft > bright) {
      if (right != null && right.isRed()) {
        right.setRed(false);
      } else {
        rotationLL(left, node);
        color(left, true);
        linkNodes(node, parent, left);
      }
    }
    if (!validateBlackNodes(node)) {
      selfBalanceDeletion(node, parent);
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
