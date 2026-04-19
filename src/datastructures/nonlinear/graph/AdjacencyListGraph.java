package datastructures.nonlinear.graph;

import datastructures.linear.Stack;
import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;
import datastructures.linear.queue.Queue;

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
    List<Vertex<V>> list = new LinkedList<>(vertex);
    Queue<Vertex<V>> queue = new Queue<>(vertex);
    do {
      Vertex<V> vrtx = queue.dequeue();
      graph
        .get(vertices.indexOf(vrtx))
        .forEach(v -> {
          if (!list.contains(v)) {
            list.add(v);
            queue.enqueue(v);
          }
        });
    } while (!queue.isEmpty());
    return list;
  }

  @Override
  public List<Vertex<V>> depthFirstSearch(Vertex<V> vertex) {
    List<Vertex<V>> list = new LinkedList<>(vertex);
    Stack<Vertex<V>> stack = new Stack<>(vertex);
    do {
      Vertex<V> vrtx = stack.pop();
      LinkedList<Vertex<V>> vrtxList = graph.get(vertices.indexOf(vrtx));
      for (int i = 0; i < vrtxList.size(); i++) {
        Vertex<V> v = vrtxList.get(i);
        if (!list.contains(v)) {
          stack.push(vrtx);
          stack.push(v);
          list.add(v);
          break;
        }
      }
    } while (!stack.isEmpty());
    return list;
  }
}
