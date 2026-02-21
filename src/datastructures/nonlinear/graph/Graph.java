package datastructures.nonlinear.graph;

public interface Graph<V> {
  void addVertex(Vertex<V> vertex);

  void addEdge(int source, int destination);

  boolean checkEdge(int source, int destination);
}
