package operations;

import datastructures.linear.linkedlist.LinkedList;
import datastructures.nonlinear.tree.binarytree.RedBlackTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedBlackTreeOperations {

  public static void operations() {
    int[] values = Randomize.randomizeArray(15);
    RedBlackTree rbt = new RedBlackTree(values);
    LinkedList<Integer> rbtValues = rbt.get();
    int[] sortedValues = new int[rbtValues.size()];
    for (int i = 0; i < rbtValues.size(); i++) {
      sortedValues[i] = rbtValues.get(i);
    }
    System.out.println("Array:          " + Arrays.toString(values));
    System.out.println("Sorted Array:   " + Arrays.toString(sortedValues));
    System.out.println("Red-Black Tree: " + rbt.get());
    rbt.clear();
    test(values, sortedValues);
  }

  private static void test(int[] values, int[] sortedValues) {
    RedBlackTree rbt = new RedBlackTree();
    List<Integer> expectedValues = new ArrayList<>();
    LinkedList<Integer> rbtValues = null;
    int n = sortedValues.length;
    for (int window = 1; window <= n; window++) {
      // Starting index
      for (int start = 0; start < n; start++) {
        rbt.insert(values);
        for (int sv : sortedValues) {
          expectedValues.add(sv);
        }
        // Print window elements
        for (int offset = 0; offset < window; offset++) {
          int index = (start + offset) % n;
          expectedValues.remove(Integer.valueOf(sortedValues[index]));
          boolean deleted = rbt.delete(sortedValues[index]);
          rbtValues = rbt.get();
          if (deleted && rbtValues.size() != expectedValues.size()) {
            System.out.println(
              "Problem in deleting the " + sortedValues[index]
            );
            System.out.println("Counter " + window);
            return;
          } else {
            for (int i = 0; i < expectedValues.size(); i++) {
              int e = expectedValues.get(i);
              int r = rbtValues.get(i);
              if (e != r) {
                System.out.println(
                  "Problem in deleting the " + sortedValues[index]
                );
                System.out.println("Counter " + window);
                System.out.println("Expected: " + expectedValues);
                System.out.println("Actual: " + rbtValues);
                return;
              }
            }
          }
        }
        rbt.clear();
        expectedValues.clear();
      }
    }
  }
}
