package datastructures.nonlinear.tree.binarytree;

import java.util.function.Predicate;

public class BinarySearchTree extends BinaryTree<Integer> {

  public BinarySearchTree() {
    super();
  }

  public BinarySearchTree(int[] values) {
    super();
    insert(values);
  }

  public void insert(int[] values) {
    for (int value : values) {
      insert(value);
    }
  }

  public void insert(int value) {
    insert(new BinaryTreeNode<>(value));
  }

  protected void insert(BinaryTreeNode<Integer> node) {
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

  public boolean search(int value) {
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

  public boolean delete(int value) {
    BinaryTreeNode<Integer> child = root, parent = null;
    while (child != null) {
      if (value == child.getValue()) {
        delete(child, parent);
        return true;
      } else {
        parent = child;
        child = value < child.getValue() ? child.getLeft() : child.getRight();
      }
    }
    return false;
  }

  protected void delete(
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
      deleteNode(child, parent);
    } else {
      delete(child, parent);
    }
  }

  private void deleteNode(
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

  @SuppressWarnings("unchecked")
  protected <T extends BinaryTreeNode<Integer>> T getChild(
    T node,
    Predicate<T> condition
  ) {
    return (T) (condition.test(node) ? node.getLeft() : node.getRight());
  }
}
