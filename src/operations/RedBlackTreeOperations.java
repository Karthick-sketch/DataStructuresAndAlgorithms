package operations;

// import datastructures.linear.linkedlist.LinkedList;
import datastructures.nonlinear.tree.binarytree.RedBlackTree;
import java.util.Arrays;

public class RedBlackTreeOperations {

  public static void operations() {
    // int[] values = Randomize.randomizeArray(15);
    int[] values = {
      85,
      33,
      47,
      48,
      81,
      71,
      19,
      14,
      24,
      30,
      57,
      99,
      98,
      25,
      93,
    };

    // 85, 33, 47, 48, 81, 71, 19, 14, 24, 30, 57, 99, 98, 25, 93
    RedBlackTree rbt = new RedBlackTree(values);
    System.out.println("Array:          " + Arrays.toString(values));
    System.out.println("Red-Black Tree: " + rbt.get());
    // problem in deleting 19
    System.out.printf("Delete %d: %b\n", 19, rbt.delete(19));
    System.out.println("Red-Black Tree: " + rbt.get());
    // RedBlackTree rbt = new RedBlackTree();
    // System.out.println("Array:          " + Arrays.toString(values));
    // for (int i = 0; i < values.length; i++) {
    //   rbt.insert(values);
    //   System.out.println("Red-Black Tree: " + rbt.get());
    //   System.out.printf("Delete %d: %b\n", values[i], rbt.delete(values[i]));
    //   LinkedList<Integer> rbtValues = rbt.get();
    //   System.out.printf("Red-Black Tree: %s\n\n", rbtValues);
    //   rbt.clear();
    //   if (rbtValues.size() != values.length - 1) {
    //     System.out.println("Problem in deleting the " + values[i]);
    //     break;
    //   }
    // }
  }
}
