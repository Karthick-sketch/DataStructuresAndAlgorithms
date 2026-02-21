package operations;

import datastructures.nonlinear.heap.AdjacencyListGraph;

public class AdjacencyListGraphOperations {

  public static void operations() {
    AdjacencyListGraph<Integer> alg = new AdjacencyListGraph<>();
    alg.add(1, 2);
    alg.add(1, 3);
    alg.add(1, 4);
    alg.add(2, 1);
    alg.add(2, 3);
    alg.add(3, 1);
    alg.add(3, 2);
    alg.add(4, 1);
    alg.print();
  }
}
