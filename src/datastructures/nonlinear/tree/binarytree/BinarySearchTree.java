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
    BinaryTreeNode<Integer> child = root, parent = root;
    while (child != null) {
      if (value == child.getValue()) {
        if (child.getLeft() != null && child.getRight() != null) {
          BinaryTreeNode<Integer> current = child;
          parent = child;
          child = child.getLeft();
          while (child.getRight() != null) {
            parent = child;
            child = child.getRight();
          }
          swapValue(current, child);
        }
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
    BinaryTreeNode<Integer> current = getChild(child, c -> c.getLeft() != null);
    if (child == root) {
      root = current;
    } else if (child == parent.getLeft()) {
      parent.setLeft(current);
    } else {
      parent.setRight(current);
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

  protected <T extends BinaryTreeNode<Integer>> void swapValue(T a, T b) {
    int value = a.getValue();
    a.setValue(b.getValue());
    b.setValue(value);
  }
}
