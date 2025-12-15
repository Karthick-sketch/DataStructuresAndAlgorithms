package datastructures.nonlinear.tree.binarytree;

public class BinaryTree<B> {

  protected BinaryTreeNode<B> root;

  // input: [4, 2, 6, 1, 3, 5, 7]
  // output: [1, 2, 5, 4, 3, 6, 7]

  public void insert(B value) {
    BinaryTreeNode<B> node = new BinaryTreeNode<>(value);
    if (root == null) {
      root = node;
    } else {
      BinaryTreeNode<B> temp = root;
      int leftHeight, rightHeight;
      while (temp != null) {
        leftHeight = findHeight(temp.getLeft());
        rightHeight = findHeight(temp.getRight());
        if (leftHeight == 0) {
          temp.setLeft(node);
          break;
        } else if (rightHeight == 0) {
          temp.setRight(node);
          break;
        } else if (leftHeight == rightHeight) {
          temp = temp.getLeft();
        } else {
          temp = temp.getRight();
        }
      }
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
    print(root);
  }

  private void print(BinaryTreeNode<B> node) {
    if (node == null) {
      return;
    }
    print(node.getLeft());
    System.out.println(node.getValue());
    print(node.getRight());
  }
}
