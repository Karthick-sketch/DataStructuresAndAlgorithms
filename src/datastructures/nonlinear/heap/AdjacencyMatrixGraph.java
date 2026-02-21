package datastructures.nonlinear.heap;

import java.util.HashMap;

public class AdjacencyMatrixGraph<V> {

  private int[][] matrix;
  private HashMap<V, Integer> vertexMap;
  private int vertexMapIncr = 0;

  public AdjacencyMatrixGraph(int length) {
    matrix = new int[length][length];
    vertexMap = new HashMap<>();
  }

  public void print() {
    for (int[] vertices : matrix) {
      for (int vertex : vertices) {
        System.out.print(vertex + " ");
      }
      System.out.println();
    }
  }

  public void add(V v1, V v2) {
    int v1i = getVertexIndex(v1);
    int v2i = getVertexIndex(v2);
    matrix[v1i][v2i] = 1;
  }

  private int getVertexIndex(V vertex) {
    Integer index = vertexMap.get(vertex);
    if (index == null) {
      vertexMap.put(vertex, vertexMapIncr++);
      index = vertexMap.get(vertex);
    }
    return index;
  }
}
