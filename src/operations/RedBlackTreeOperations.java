package operations;

import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;
import datastructures.nonlinear.tree.binarytree.RedBlackTree;
import java.util.Arrays;

public class RedBlackTreeOperations {

  public static void operations() {
    int[] values = OperationHelper.randomizeArray(15);

    RedBlackTree rbt = new RedBlackTree(values);
    System.out.println("Array:      " + Arrays.toString(values));

    // validation
    if (validate(rbt, values)) {
      System.out.println("Iterative:  " + rbt.get());
      System.out.println("In-order:   " + rbt.getInOrder());
      System.out.println("Pre-order:  " + rbt.getPreOrder());
      System.out.println("Post-order: " + rbt.getPostOrder());

      System.out.println("Max Height: " + rbt.findMaxHeight());
      System.out.println("Min Height: " + rbt.findMinHeight());

      System.out.printf("Search %d: %b\n", values[5], rbt.find(values[5]));
      System.out.printf("Delete %d: %b\n", values[8], rbt.remove(values[8]));
      System.out.println(rbt.get());

      System.out.println("Maximum: " + rbt.maximum());
      System.out.println("Minimum: " + rbt.minimum());
      System.out.println("Max Height: " + rbt.findMaxHeight());
      System.out.println("Min Height: " + rbt.findMinHeight());

      rbt.clear();
      System.out.println(rbt.get());
    }
  }

  private static boolean validate(RedBlackTree rbt, int[] values) {
    List<Integer> list = rbt.get();
    int[] sortedValues = new int[list.size()];
    for (int i = 0; i < sortedValues.length; i++) {
      sortedValues[i] = list.get(i);
    }
    return test(values, sortedValues);
  }

  private static boolean test(int[] values, int[] sortedValues) {
    RedBlackTree rbt = new RedBlackTree();
    List<Integer> expectedValues = new LinkedList<>();
    List<Integer> rbtValues = null;
    int n = sortedValues.length;
    for (int window = 1; window <= n; window++) {
      // Starting index
      for (int start = 0; start < n; start++) {
        rbt.add(values);
        expectedValues.addAll(OperationHelper.toIntegerArray(sortedValues));
        // Print window elements
        for (int offset = 0; offset < window; offset++) {
          int index = (start + offset) % n;
          expectedValues.remove(Integer.valueOf(sortedValues[index]));
          boolean deleted = rbt.remove(sortedValues[index]);
          rbtValues = rbt.get();
          if (deleted && rbtValues.size() != expectedValues.size()) {
            System.out.println(
              "Problem in deleting the " + sortedValues[index]
            );
            System.out.println("Counter " + window);
            return false;
          } else {
            for (int i = 0; i < expectedValues.size(); i++) {
              if (expectedValues.get(i) != rbtValues.get(i)) {
                System.out.println(
                  "Problem in deleting the " + sortedValues[index]
                );
                System.out.println("Counter " + window);
                System.out.println("Expected: " + expectedValues);
                System.out.println("Actual: " + rbtValues);
                return false;
              }
            }
          }
        }
        rbt.clear();
        expectedValues.clear();
      }
    }
    return true;
  }
}
