package datastructures.nonlinear.tree.binarytree;

import datastructures.linear.Stack;
import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

public class BinaryTree<B> {

  protected BinaryTreeNode<B> root;

  private final Stack<BinaryTreeNode<B>> stack;

  public BinaryTree() {
    this.root = null;
    this.stack = new Stack<>();
  }

  public BinaryTree(B[] values) {
    this();
    add(values);
  }

  public void add(B[] values) {
    for (B value : values) {
      add(value);
    }
  }

  public void add(B value) {
    BinaryTreeNode<B> node = new BinaryTreeNode<>(value);
    if (root == null) {
      root = node;
      stack.push(root);
    } else {
      BinaryTreeNode<B> temp = stack.peek();
      if (temp.getLeft() == null) {
        temp.setLeft(node);
      } else if (temp.getRight() == null) {
        temp.setRight(node);
      } else {
        stack.pop();
        int lMin, lMax, rMin, rMax;
        while (!stack.isEmpty()) {
          lMin = findMinHeight(stack.peek().getLeft());
          rMin = findMinHeight(stack.peek().getRight());
          lMax = findMaxHeight(stack.peek().getLeft());
          rMax = findMaxHeight(stack.peek().getRight());
          if (lMin != rMin && lMax != rMax) {
            break;
          }
          stack.pop();
        }
        temp = stack.isEmpty() ? root : stack.peek().getRight();
        while (temp != null) {
          stack.push(temp);
          temp = temp.getLeft();
        }
        stack.peek().setLeft(node);
      }
    }
  }

  public int findMaxHeight() {
    return findMaxHeight(root);
  }

  public int findMinHeight() {
    return findMinHeight(root);
  }

  protected int findMaxHeight(BinaryTreeNode<B> node) {
    if (node == null) {
      return 0;
    } else if (node.getLeft() == null && node.getRight() == null) {
      return 1;
    } else {
      int lh = findMaxHeight(node.getLeft());
      int rh = findMaxHeight(node.getRight());
      return 1 + Math.max(lh, rh);
    }
  }

  protected int findMinHeight(BinaryTreeNode<B> node) {
    if (node == null) {
      return 0;
    } else if (node.getLeft() == null && node.getRight() == null) {
      return 1;
    } else {
      int lh = findMinHeight(node.getLeft());
      int rh = findMinHeight(node.getRight());
      return 1 + Math.min(lh, rh);
    }
  }

  public List<B> get() {
    List<B> list = new LinkedList<>();
    Stack<BinaryTreeNode<B>> stack = new Stack<>();
    BinaryTreeNode<B> current = root;
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

  public List<B> getInOrder() {
    List<B> list = new LinkedList<>();
    inOrder(root, list);
    return list;
  }

  private void inOrder(BinaryTreeNode<B> current, List<B> list) {
    if (current == null) {
      return;
    }
    inOrder(current.getLeft(), list);
    list.add(current.getValue());
    inOrder(current.getRight(), list);
  }

  public List<B> getPreOrder() {
    List<B> list = new LinkedList<>();
    preOrder(root, list);
    return list;
  }

  private void preOrder(BinaryTreeNode<B> current, List<B> list) {
    if (current == null) {
      return;
    }
    list.add(current.getValue());
    preOrder(current.getLeft(), list);
    preOrder(current.getRight(), list);
  }

  public List<B> getPostOrder() {
    List<B> list = new LinkedList<>();
    postOrder(root, list);
    return list;
  }

  private void postOrder(BinaryTreeNode<B> current, List<B> list) {
    if (current == null) {
      return;
    }
    postOrder(current.getLeft(), list);
    postOrder(current.getRight(), list);
    list.add(current.getValue());
  }

  public void clear() {
    root = null;
  }
}
