package datastructures.nonlinear.tree.binarytree;

import datastructures.linear.Stack;
import datastructures.linear.linkedlist.LinkedList;
import datastructures.linear.linkedlist.SinglyLinkedList;

public class RedBlackTree {

  private RedBlackTreeNode root;

  public RedBlackTree() {
    root = null;
  }

  public RedBlackTree(int[] values) {
    insert(values);
  }

  public void insert(int[] values) {
    for (int value : values) {
      insert(value);
    }
  }

  public void insert(int value) {
    insert(new RedBlackTreeNode(value));
    selfBalance(root, null, null, null);
    if (root.isRed()) {
      root.setRed(false);
    }
  }

  private void insert(RedBlackTreeNode node) {
    if (root == null) {
      root = node;
    } else {
      RedBlackTreeNode current = root;
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

  private boolean selfBalance(
    RedBlackTreeNode child,
    RedBlackTreeNode parent,
    RedBlackTreeNode grand,
    RedBlackTreeNode great
  ) {
    if (child == null) {
      return false;
    }
    boolean left = selfBalance(child.getLeft(), child, parent, grand);
    boolean right = !left
      ? selfBalance(child.getRight(), child, parent, grand)
      : false;
    if (left || right) {
      return selfBalance(root, null, null, null);
    } else if (grand != null && parent.isRed() && child.isRed()) {
      if (grand.getLeft() == parent) {
        if (grand.getRight() == null || !grand.getRight().isRed()) {
          if (parent.getRight() == child) {
            // LR rotation
            grand.setLeft(child);
            parent.setRight(child.getLeft());
            child.setLeft(parent);
            parent = child;
          }
          // LL rotation
          grand.setRight(parent.getLeft());
          parent.setLeft(grand);
          linkNodes(parent, grand, great);
          colorRotation(parent);
        } else {
          // recolor
          recolor(grand);
        }
      } else {
        if (grand.getLeft() == null || !grand.getLeft().isRed()) {
          if (parent.getLeft() == child) {
            // RL rotation
            grand.setRight(child);
            parent.setLeft(child.getRight());
            child.setRight(parent);
            parent = child;
          }
          // RR rotation
          grand.setRight(parent.getLeft());
          parent.setLeft(grand);
          linkNodes(parent, grand, great);
          colorRotation(parent);
        } else {
          // recolor
          recolor(grand);
        }
      }
      return true;
    }
    return false;
  }

  private void linkNodes(
    RedBlackTreeNode child,
    RedBlackTreeNode parent,
    RedBlackTreeNode grand
  ) {
    if (parent == root) {
      root = child;
    } else if (grand.getLeft() == parent) {
      grand.setLeft(child);
    } else {
      grand.setRight(child);
    }
  }

  private void recolor(RedBlackTreeNode node) {
    node.setRed(true);
    node.getLeft().setRed(false);
    node.getRight().setRed(false);
  }

  private void colorRotation(RedBlackTreeNode node) {
    node.setRed(false);
    node.getLeft().setRed(true);
    node.getRight().setRed(true);
  }

  public LinkedList<Integer> get() {
    LinkedList<Integer> list = new SinglyLinkedList<>();
    Stack<RedBlackTreeNode> stack = new Stack<>();
    RedBlackTreeNode current = root;
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
}
