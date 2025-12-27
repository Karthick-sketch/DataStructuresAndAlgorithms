package operations;

import algorithms.sort.InsertionSort;
import datastructures.linear.linkedlist.LinkedList;
import datastructures.nonlinear.tree.binarytree.RedBlackTree;
import java.util.Arrays;

public class RedBlackTreeOperations {

  public static void operations() {
    // int[] values = Randomize.randomizeArray(15);
    int[] values = {
      96,
      70,
      54,
      64,
      89,
      22,
      19,
      54,
      69,
      74,
      10,
      75,
      86,
      73,
      34,
    };
    int[] sortedValues = Arrays.copyOf(values, values.length);
    new InsertionSort().sort(sortedValues);

    RedBlackTree rbt = new RedBlackTree();
    System.out.println("Array:          " + Arrays.toString(values));
    System.out.println("Sorted Array:   " + Arrays.toString(sortedValues));
    test(rbt, values, sortedValues);
  }

  private static void test(RedBlackTree rbt, int[] values, int[] sortedValues) {
    LinkedList<Integer> rbtValues = null;
    int n = sortedValues.length;
    for (int window = 1; window <= n; window++) {
      System.out.println("\nSize " + window + ":");

      // Starting index
      for (int start = 0; start < n; start++) {
        rbt.insert(values);
        // Print window elements
        for (int offset = 0; offset < window; offset++) {
          int index = (start + offset) % n;
          boolean deleted = rbt.delete(sortedValues[index]);
          rbtValues = rbt.get();
          if (
            deleted && rbtValues.size() != sortedValues.length - (offset + 1)
          ) {
            System.out.println(
              "Problem in deleting the " + sortedValues[index]
            );
            System.out.println("Counter " + window);
            return;
          }
        }
        rbt.clear();
        System.out.println("Red-Black Tree: " + rbtValues);
      }
    }
  }
}
