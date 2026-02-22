package operations;

import datastructures.nonlinear.graph.AdjacencyMatrixGraph;
import datastructures.nonlinear.graph.Vertex;

public class AdjacencyMatrixGraphOperations {

  public static void operations() {
    AdjacencyMatrixGraph<Character> amg = new AdjacencyMatrixGraph<>(4);
    amg.addVertex(new Vertex<>('A'));
    amg.addVertex(new Vertex<>('B'));
    amg.addVertex(new Vertex<>('C'));
    amg.addVertex(new Vertex<>('D'));

    amg.addEdge(0, 1);
    amg.addEdge(0, 2);
    amg.addEdge(0, 3);
    amg.addEdge(1, 0);
    amg.addEdge(1, 2);
    amg.addEdge(2, 0);
    amg.addEdge(2, 1);
    amg.addEdge(3, 0);

    System.out.println("A -> B: " + amg.checkEdge(0, 1));
    System.out.println("C -> D: " + amg.checkEdge(2, 3));

    amg.print();
  }
}
