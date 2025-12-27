package operations;

import algorithms.sort.InsertionSort;
import datastructures.linear.linkedlist.LinkedList;
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
    int[] sortedValues = Arrays.copyOf(values, values.length);
    new InsertionSort().sort(sortedValues);
    // 85, 33, 47, 48, 81, 71, 19, 14, 24, 30, 57, 99, 98, 25, 93
    // RedBlackTree rbt = new RedBlackTree(values);
    // System.out.println("Array:          " + Arrays.toString(values));
    // System.out.println("Red-Black Tree: " + rbt.get());
    // problem in deleting 19
    // System.out.printf("Delete %d: %b\n", 19, rbt.delete(19));
    // System.out.println("Red-Black Tree: " + rbt.get());
    //
    LinkedList<Integer> rbtValues;
    RedBlackTree rbt = new RedBlackTree();
    System.out.println("Array:          " + Arrays.toString(values));
    System.out.println("Sorted Array:   " + Arrays.toString(sortedValues));

    int n = sortedValues.length;

    // Window size from 1 to 15
    for (int window = 1; window <= n; window++) {
      System.out.println("\nSize " + window + ":");

      // Starting index
      for (int start = 0; start < n; start++) {
        rbt.insert(values);
        // Print window elements
        for (int offset = 0; offset < window; offset++) {
          int index = (start + offset) % n;
          System.out.printf(
            "Delete %d: %b\n",
            sortedValues[index],
            rbt.delete(sortedValues[index])
          );
          rbtValues = rbt.get();
          System.out.println("Red-Black Tree: " + rbtValues);
          if (rbtValues.size() != sortedValues.length - (offset + 1)) {
            System.out.println(
              "Problem in deleting the " + sortedValues[index]
            );
            System.out.println("Counter " + window);
            return;
          }
        }
        rbt.clear();
      }
    }
  }
}
