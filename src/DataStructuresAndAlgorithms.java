import java.util.Scanner;
import operations.*;

public class DataStructuresAndAlgorithms {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int ip;
    do {
      System.out.println("0. Exit\n1. Search\n2. Sort");
      System.out.println(
        "3. Linked List\n4. Stack\n5. Queue\n6. Binary Search Tree"
      );
      System.out.println("\n > ");
      ip = scanner.nextInt();
      switch (ip) {
        case 1:
          SearchOperations.operations();
          break;
        case 2:
          SortOperations.operations();
          break;
        case 3:
          LinkedListOperations.operations();
          break;
        case 4:
          StackOperations.operations();
          break;
        case 5:
          QueueOperations.operations();
          break;
        case 6:
          TreeOperations.operations();
      }
    } while (ip != 0);
    scanner.close();
  }
}
