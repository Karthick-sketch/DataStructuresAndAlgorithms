package datastructures.nonlinear.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

  protected BinaryTreeNode<Integer> root;

  public BinarySearchTree(int[] values) {
    insert(values);
  }

  public void insert(int[] values) {
    for (int value : values) {
      insert(value);
    }
  }

  public void insert(int value) {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(value);
    if (root == null) {
      root = node;
    } else {
      BinaryTreeNode<Integer> current = root;
      while (true) {
        if (value < current.getValue()) {
          if (current.getLeft() == null) {
            current.setLeft(node);
            break;
          }
          current = current.getLeft();
        } else if (value > current.getValue()) {
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

  public List<Integer> get() {
    List<Integer> list = new ArrayList<>();
    Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
    BinaryTreeNode<Integer> current = root;
    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.getLeft();
      }
      current = stack.pop();
      list.add(current.getValue());
      current = current.getRight();
    }
    return list;
  }

  public List<Integer> getInOrder() {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    return list;
  }

  private void inOrder(BinaryTreeNode<Integer> current, List<Integer> list) {
    if (current != null) {
      inOrder(current.getLeft(), list);
      list.add(current.getValue());
      inOrder(current.getRight(), list);
    }
  }

  public List<Integer> getPreOrder() {
    List<Integer> list = new ArrayList<>();
    preOrder(root, list);
    return list;
  }

  private void preOrder(BinaryTreeNode<Integer> current, List<Integer> list) {
    if (current != null) {
      list.add(current.getValue());
      preOrder(current.getLeft(), list);
      preOrder(current.getRight(), list);
    }
  }

  public List<Integer> getPostOrder() {
    List<Integer> list = new ArrayList<>();
    postOrder(root, list);
    return list;
  }

  private void postOrder(BinaryTreeNode<Integer> current, List<Integer> list) {
    if (current != null) {
      postOrder(current.getLeft(), list);
      postOrder(current.getRight(), list);
      list.add(current.getValue());
    }
  }

  public boolean delete(int value) {
    BinaryTreeNode<Integer> child = root, parent = root;
    while (child != null) {
      if (value == child.getValue()) {
        if (child.getLeft() != null && child.getRight() != null) {
          BinaryTreeNode<Integer> current = child.getLeft(), previous = null;
          while (current.getRight() != null) {
            previous = current;
            current = current.getRight();
          }
          child.setValue(current.getValue());
          if (previous == null) {
            child.setLeft(null);
          } else {
            previous.setRight(null);
          }
        } else {
          BinaryTreeNode<Integer> current = null;
          if (child.getLeft() != null) {
            current = child.getLeft();
          } else if (child.getRight() != null) {
            current = child.getRight();
          }
          if (child == root) {
            root = current;
          } else if (child == parent.getLeft()) {
            parent.setLeft(current);
          } else {
            parent.setRight(current);
          }
        }
        return true;
      } else {
        parent = child;
        child = value < child.getValue() ? child.getLeft() : child.getRight();
      }
    }
    return false;
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

  public void clear() {
    root = null;
  }
}
