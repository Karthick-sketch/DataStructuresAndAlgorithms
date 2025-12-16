package datastructures.nonlinear.tree.binarytree;

import datastructures.linear.Stack;

public class BinaryTree<B> {

  protected BinaryTreeNode<B> root;

  private Stack<BinaryTreeNode<B>> stack;

  public BinaryTree() {
    this.root = null;
    this.stack = new Stack<>();
  }

  public BinaryTree(B[] values) {
    this();
    insert(values);
  }

  public void insert(B[] values) {
    for (B value : values) {
      insert(value);
    }
  }

  public void insert(B value) {
    insert(new BinaryTreeNode<>(value));
  }

  // input           : [63, 0, 48, 17, 58, 15, 76, 73, 61, 82, 35, 88]
  // actual output   : [88, 73, 17, 61, 0, 82, 58, 35, 63, 15, 48, 76]
  // expected output : [73, 17, 61, 0, 82, 58, 35, 63, 88, 15, 48, 76]

  private void insert(BinaryTreeNode<B> node) {
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
        BinaryTreeNode<B> nd = stack.pop();
        if (stack.isEmpty()) {
          fillStack();
          stack.peek().setLeft(node);
        } else {
          while (!stack.isEmpty() && stack.peek().getRight() == nd) {
            nd = stack.pop();
          }
          if (stack.isEmpty()) {
            fillStack();
            stack.peek().setLeft(node);
          } else {
            stack.push(stack.peek().getRight());
            insert(node);
          }
        }
      }
    }
  }

  private void fillStack() {
    BinaryTreeNode<B> temp = root;
    while (temp != null) {
      stack.push(temp);
      temp = temp.getLeft();
    }
  }

  public int findHeight() {
    return findHeight(root);
  }

  protected int findHeight(BinaryTreeNode<B> node) {
    if (node == null) {
      return 0;
    } else if (node.getLeft() == null && node.getRight() == null) {
      return 1;
    } else {
      int lh = findHeight(node.getLeft());
      int rh = findHeight(node.getRight());
      return 1 + Math.max(lh, rh);
    }
  }

  public void print() {
    System.out.print("[ ");
    print(root);
    System.out.println("]");
  }

  private void print(BinaryTreeNode<B> node) {
    if (node == null) {
      return;
    }
    print(node.getLeft());
    System.out.print(node.getValue() + " ");
    print(node.getRight());
  }
}
