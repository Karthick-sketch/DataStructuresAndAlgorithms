package operations;

import datastructures.nonlinear.heap.AdjacencyMatrixGraph;

public class AdjacencyMatrixGraphOperations {

  public static void operations() {
    AdjacencyMatrixGraph<Integer> amg = new AdjacencyMatrixGraph<>(4);
    amg.add(1, 2);
    amg.add(1, 3);
    amg.add(1, 4);
    amg.add(2, 1);
    amg.add(2, 3);
    amg.add(3, 1);
    amg.add(3, 2);
    amg.add(4, 1);
    amg.print();
  }
}
