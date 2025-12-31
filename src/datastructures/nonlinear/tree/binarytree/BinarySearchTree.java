package datastructures.nonlinear.tree.binarytree;

public class BinarySearchTree extends BinaryTree<Integer> {

  public BinarySearchTree() {
    super();
  }

  public BinarySearchTree(int[] values) {
    super();
    add(values);
  }

  public void add(int[] values) {
    for (int value : values) {
      add(value);
    }
  }

  public void add(int value) {
    add(new BinaryTreeNode<>(value));
  }

  protected void add(BinaryTreeNode<Integer> node) {
    if (root == null) {
      root = node;
    } else {
      BinaryTreeNode<Integer> current = root;
      while (true) {
        if (node.getValue() < current.getValue()) {
          if (current.getLeft() == null) {
            current.setLeft(node);
            break;
          }
          current = current.getLeft();
        } else if (node.getValue() > current.getValue()) {
          if (current.getRight() == null) {
            current.setRight(node);
            break;
          }
          current = current.getRight();
        } else {
          break;
        }
      }
    }
  }

  public boolean find(int value) {
    BinaryTreeNode<Integer> current = root;
    while (current != null) {
      if (value == current.getValue()) {
        return true;
      } else if (value < current.getValue()) {
        current = current.getLeft();
      } else {
        current = current.getRight();
      }
    }
    return false;
  }

  public boolean remove(int value) {
    BinaryTreeNode<Integer> child = root, parent = null;
    while (child != null) {
      if (value == child.getValue()) {
        remove(child, parent);
        return true;
      } else {
        parent = child;
        child = value < child.getValue() ? child.getLeft() : child.getRight();
      }
    }
    return false;
  }

  protected void remove(
    BinaryTreeNode<Integer> child,
    BinaryTreeNode<Integer> parent
  ) {
    if (child.getLeft() != null || child.getRight() != null) {
      BinaryTreeNode<Integer> current = child;
      parent = child;
      if (child.getLeft() != null) {
        // in-order predecessor
        child = child.getLeft();
        while (child.getRight() != null) {
          parent = child;
          child = child.getRight();
        }
      } else {
        // in-order successor
        child = child.getRight();
        while (child.getLeft() != null) {
          parent = child;
          child = child.getLeft();
        }
      }
      int value = current.getValue();
      current.setValue(child.getValue());
      child.setValue(value);
    }
    if (child.getLeft() == null && child.getRight() == null) {
      removeNode(child, parent);
    } else {
      remove(child, parent);
    }
  }

  private void removeNode(
    BinaryTreeNode<Integer> child,
    BinaryTreeNode<Integer> parent
  ) {
    if (child == root) {
      root = null;
    } else if (child == parent.getLeft()) {
      parent.setLeft(null);
    } else {
      parent.setRight(null);
    }
  }

  public int maximum() {
    BinaryTreeNode<Integer> current = root;
    while (current.getRight() != null) {
      current = current.getRight();
    }
    return current.getValue();
  }

  public int minimum() {
    BinaryTreeNode<Integer> current = root;
    while (current.getLeft() != null) {
      current = current.getLeft();
    }
    return current.getValue();
  }
}
