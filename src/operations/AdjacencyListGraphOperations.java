package operations;

import datastructures.nonlinear.graph.AdjacencyListGraph;
import datastructures.nonlinear.graph.Vertex;

public class AdjacencyListGraphOperations {

  public static void operations() {
    AdjacencyListGraph<Character> alg = new AdjacencyListGraph<>();
    Vertex<Character> vertexA = new Vertex<>('A');
    Vertex<Character> vertexC = new Vertex<>('C');
    Vertex<Character> vertexE = new Vertex<>('E');
    alg.addVertex(vertexA);
    alg.addVertex(new Vertex<>('B'));
    alg.addVertex(vertexC);
    alg.addVertex(new Vertex<>('D'));
    alg.addVertex(vertexE);
    alg.addVertex(new Vertex<>('F'));
    alg.addVertex(new Vertex<>('G'));
    alg.addVertex(new Vertex<>('H'));

    alg.addEdge(0, 1);
    alg.addEdge(0, 2);
    alg.addEdge(0, 3);
    alg.addEdge(0, 4);
    alg.addEdge(1, 0);
    alg.addEdge(1, 5);
    alg.addEdge(1, 6);
    alg.addEdge(2, 0);
    alg.addEdge(2, 5);
    alg.addEdge(2, 6);
    alg.addEdge(3, 1);
    alg.addEdge(3, 5);
    alg.addEdge(4, 2);
    alg.addEdge(4, 6);
    alg.addEdge(4, 7);
    alg.addEdge(5, 1);
    alg.addEdge(5, 6);
    alg.addEdge(6, 5);

    System.out.println("A -> B: " + alg.checkEdge(0, 1));
    System.out.println("C -> D: " + alg.checkEdge(2, 3));

    alg.print();

    System.out.println("BFS: A -> " + alg.breadthFirstSearch(vertexA));
    System.out.println("BFS: C -> " + alg.breadthFirstSearch(vertexC));
    System.out.println("BFS: E -> " + alg.breadthFirstSearch(vertexE));

    System.out.println("\nDFS: A -> " + alg.depthFirstSearch(vertexA));
    System.out.println("DFS: C -> " + alg.depthFirstSearch(vertexC));
    System.out.println("DFS: E -> " + alg.depthFirstSearch(vertexE));
  }
}
