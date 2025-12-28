import java.util.Scanner;
import operations.*;

public class DataStructuresAndAlgorithms {

  private static final Scanner scanner = new Scanner(System.in);
  private static int input;

  public static void main(String[] args) {
    start();
  }

  private static void start() {
    System.out.println("0. Exit\n1. Algorithms\n2. Data Structures");
    System.out.print("> ");
    input = scanner.nextInt();
    switch (input) {
      case 0:
        exit();
        break;
      case 1:
        algorithms();
        break;
      case 2:
        dataStructures();
        break;
      default:
        start();
    }
  }

  private static void algorithms() {
    System.out.println("0. Back\n1. Search\n2. Sort");
    System.out.print("> ");
    input = scanner.nextInt();
    if (input == 0) {
      start();
    } else {
      if (input == 1) {
        SearchOperations.operations(scanner);
      } else if (input == 2) {
        SortOperations.operations();
      }
      algorithms();
    }
  }

  private static void dataStructures() {
    System.out.println("0. Back\n1. Linked List\n2. Stack\n3. Queue\n4. Heap");
    System.out.println("4. Heap\n5. Hash Table\n6. Binary Tree");
    System.out.println("7. Binary Search Tree\n8. AVL Tree\n9. Red-Black Tree");
    System.out.print("> ");
    input = scanner.nextInt();
    if (input == 0) {
      start();
    } else {
      if (input == 1) {
        LinkedListOperations.operations();
      } else if (input == 2) {
        StackOperations.operations();
      } else if (input == 3) {
        QueueOperations.operations();
      } else if (input == 4) {
        HeapOperations.operations();
      } else if (input == 5) {
        HashTableOperations.operations();
      } else if (input == 6) {
        BinaryTreeOperations.operations();
      } else if (input == 7) {
        BinarySearchTreeOperations.operations();
      } else if (input == 8) {
        AVLTreeOperations.operations();
      } else if (input == 9) {
        RedBlackTreeOperations.operations();
      }
      dataStructures();
    }
  }

  private static void exit() {
    scanner.close();
  }
}
