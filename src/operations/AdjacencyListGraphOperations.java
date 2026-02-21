package operations;

import datastructures.nonlinear.graph.AdjacencyListGraph;
import datastructures.nonlinear.graph.Vertex;

public class AdjacencyListGraphOperations {

  public static void operations() {
    AdjacencyListGraph<Character> alg = new AdjacencyListGraph<>();
    alg.addVertex(new Vertex<>('A'));
    alg.addVertex(new Vertex<>('B'));
    alg.addVertex(new Vertex<>('C'));
    alg.addVertex(new Vertex<>('D'));

    alg.addEdge(0, 1);
    alg.addEdge(0, 2);
    alg.addEdge(0, 3);
    alg.addEdge(1, 0);
    alg.addEdge(1, 2);
    alg.addEdge(2, 0);
    alg.addEdge(2, 1);
    alg.addEdge(3, 0);

    alg.print();
  }
}
