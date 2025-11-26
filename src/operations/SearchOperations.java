package operations;

import algorithms.search.Search;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchOperations {

  public static void operations() {
    operations(randomize(10));
  }

  private static int[] randomize(int length) {
    Random random = new Random();
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = random.nextInt(100);
    }
    return arr;
  }

  private static void operations(int[] arr1) {
    Scanner scanner = new Scanner(System.in);
    int index;
    System.out.print("1. Linear Search\n2. Jump Search\n3. Binary Search\n> ");
    int ip = scanner.nextInt();
    if (ip >= 1 && ip <= 3) {
      if (ip == 1) {
        System.out.print("Elements: " + Arrays.toString(arr1) + "\n> ");
        index = Search.linearSearch(arr1, scanner.nextInt());
        System.out.println(index == -1 ? "Not found" : "Index: " + index);
      } else {
        List<Integer> list = Arrays.stream(arr1)
          .boxed()
          .collect(Collectors.toList());
        Collections.sort(list);
        int[] arr2 = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.print("Elements: " + Arrays.toString(arr2) + "\n> ");
        if (ip == 2) {
          index = Search.jumpSearch(arr2, scanner.nextInt());
        } else {
          index = Search.binarySearch(arr2, scanner.nextInt());
        }
        System.out.println(index == -1 ? "Not found" : "Index: " + index);
      }
    } else {
      operations(arr1);
    }
    scanner.close();
  }
}
