package datastructures.nonlinear.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListGraph<V> implements Graph<V> {

  private LinkedList<Vertex<V>> vertices;
  private LinkedList<LinkedList<Vertex<V>>> graph;

  public AdjacencyListGraph() {
    vertices = new LinkedList<>();
    graph = new LinkedList<>();
  }

  public void print() {
    for (int i = 0; i < graph.size(); i++) {
      System.out.print(vertices.get(i).getValue() + " -> ");
      graph
        .get(i)
        .forEach(vertex -> {
          System.out.print(vertex.getValue() + " -> ");
        });
      System.out.println();
    }
  }

  @Override
  public void addVertex(Vertex<V> vertex) {
    vertices.add(vertex);
    graph.add(new LinkedList<>());
  }

  @Override
  public void addEdge(int source, int destination) {
    Vertex<V> vertex = vertices.get(destination);
    LinkedList<Vertex<V>> vertexList = graph.get(source);
    vertexList.add(vertex);
  }

  @Override
  public boolean checkEdge(int source, int destination) {
    LinkedList<Vertex<V>> vertexList = graph.get(source);
    return vertexList.contains(vertices.get(destination));
  }

  @Override
  public List<Vertex<V>> breadthFirstSearch(Vertex<V> vertex) {
    List<Vertex<V>> list = new LinkedList<>(List.of(vertex));
    Queue<Vertex<V>> queue = new LinkedList<>(List.of(vertex));
    do {
      Vertex<V> vrtx = queue.poll();
      graph
        .get(vertices.indexOf(vrtx))
        .forEach(v -> {
          if (!list.contains(v)) {
            list.add(v);
            queue.add(v);
          }
        });
    } while (!queue.isEmpty());
    return list;
  }
}
