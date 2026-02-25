package datastructures.nonlinear.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyMatrixGraph<V> implements Graph<V> {

  private int[][] matrix;
  private LinkedList<Vertex<V>> vertices;

  public AdjacencyMatrixGraph(int length) {
    matrix = new int[length][length];
    vertices = new LinkedList<>();
  }

  public void print() {
    System.out.print("  ");
    for (Vertex<V> vertex : vertices) {
      System.out.print(vertex.getValue() + " ");
    }
    System.out.println();
    for (int i = 0; i < matrix.length; i++) {
      System.out.print(vertices.get(i).getValue() + " ");
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  @Override
  public void addVertex(Vertex<V> vertex) {
    vertices.add(vertex);
  }

  @Override
  public void addEdge(int source, int destination) {
    matrix[source][destination] = 1;
  }

  @Override
  public boolean checkEdge(int source, int destination) {
    return matrix[source][destination] == 1;
  }

  @Override
  public List<Vertex<V>> breadthFirstSearch(Vertex<V> vertex) {
    List<Vertex<V>> list = new LinkedList<>(List.of(vertex));
    Queue<Vertex<V>> queue = new LinkedList<>(List.of(vertex));
    do {
      Vertex<V> vrtx = queue.poll();
      int iVrtx = vertices.indexOf(vrtx);
      for (int j = 0; j < matrix[iVrtx].length; j++) {
        if (matrix[iVrtx][j] == 1) {
          Vertex<V> v = vertices.get(j);
          if (!list.contains(v)) {
            list.add(v);
            queue.add(v);
          }
        }
      }
    } while (!queue.isEmpty());
    return list;
  }
}
