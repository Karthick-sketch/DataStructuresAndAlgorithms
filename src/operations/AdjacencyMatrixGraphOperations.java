package operations;

import datastructures.nonlinear.graph.AdjacencyMatrixGraph;
import datastructures.nonlinear.graph.Vertex;

public class AdjacencyMatrixGraphOperations {

  public static void operations() {
    AdjacencyMatrixGraph<Character> amg = new AdjacencyMatrixGraph<>(8);
    Vertex<Character> vertexA = new Vertex<>('A');
    Vertex<Character> vertexC = new Vertex<>('C');
    Vertex<Character> vertexE = new Vertex<>('E');
    amg.addVertex(vertexA);
    amg.addVertex(new Vertex<>('B'));
    amg.addVertex(vertexC);
    amg.addVertex(new Vertex<>('D'));
    amg.addVertex(vertexE);
    amg.addVertex(new Vertex<>('F'));
    amg.addVertex(new Vertex<>('G'));
    amg.addVertex(new Vertex<>('H'));

    amg.addEdge(0, 1);
    amg.addEdge(0, 2);
    amg.addEdge(0, 3);
    amg.addEdge(0, 4);
    amg.addEdge(1, 0);
    amg.addEdge(1, 5);
    amg.addEdge(1, 6);
    amg.addEdge(2, 0);
    amg.addEdge(2, 5);
    amg.addEdge(2, 6);
    amg.addEdge(3, 1);
    amg.addEdge(3, 5);
    amg.addEdge(4, 2);
    amg.addEdge(4, 6);
    amg.addEdge(4, 7);
    amg.addEdge(5, 1);
    amg.addEdge(5, 6);
    amg.addEdge(6, 5);

    System.out.println("A -> B: " + amg.checkEdge(0, 1));
    System.out.println("C -> D: " + amg.checkEdge(2, 3));

    amg.print();

    System.out.println("BFS: A -> " + amg.breadthFirstSearch(vertexA));
    System.out.println("BFS: C -> " + amg.breadthFirstSearch(vertexC));
    System.out.println("BFS: E -> " + amg.breadthFirstSearch(vertexE));

    System.out.println("\nDFS: A -> " + amg.depthFirstSearch(vertexA));
    System.out.println("DFS: C -> " + amg.depthFirstSearch(vertexC));
    System.out.println("DFS: E -> " + amg.depthFirstSearch(vertexE));
  }
}
