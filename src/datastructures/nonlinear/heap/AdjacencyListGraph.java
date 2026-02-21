package datastructures.nonlinear.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AdjacencyListGraph<V> {

  private HashMap<V, List<V>> graph;

  public AdjacencyListGraph() {
    graph = new HashMap<>();
  }

  public void print() {
    Set<V> vertices = graph.keySet();
    graph.forEach((vertex, vertexList) -> {
      vertices.forEach(v -> {
        if (vertexList.contains(v)) {
          System.out.print("1 ");
        } else {
          System.out.print("0 ");
        }
      });
      System.out.println();
    });
  }

  public void add(V v1, V v2) {
    getVertexList(v1).add(v2);
  }

  private List<V> getVertexList(V vertex) {
    List<V> vertexList = graph.get(vertex);
    if (vertexList == null) {
      graph.put(vertex, new ArrayList<>());
      vertexList = graph.get(vertex);
    }
    return vertexList;
  }
}
