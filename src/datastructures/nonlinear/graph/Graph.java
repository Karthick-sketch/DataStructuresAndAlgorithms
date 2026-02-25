package datastructures.nonlinear.graph;

import java.util.List;

public interface Graph<V> {
  void addVertex(Vertex<V> vertex);

  void addEdge(int source, int destination);

  boolean checkEdge(int source, int destination);

  List<Vertex<V>> breadthFirstSearch(Vertex<V> vertex);
}
