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
    selfBalance(root.getLeft(), root);
    selfBalance(root.getRight(), root);
  }

  private void insert(RedBlackTreeNode node) {
    if (root == null) {
      root = node;
      root.setRed(false);
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

  private void selfBalance(RedBlackTreeNode node, RedBlackTreeNode parent) {
    if (node == null) {
      return;
    }
    selfBalance((RedBlackTreeNode) node.getLeft(), node);
    selfBalance((RedBlackTreeNode) node.getRight(), node);
    if (node.isRed() && parent.isRed()) {
      if (parent.getLeft() == null || !parent.getLeft().isRed()) {
        // perform rotation
      } else {
        // change color
      }
    }
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
