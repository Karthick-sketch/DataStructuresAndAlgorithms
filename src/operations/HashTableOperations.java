package operations;

import datastructures.nonlinear.hash.HashTable;
import datastructures.nonlinear.hash.LinkedMap;
import datastructures.nonlinear.hash.Map;
import java.util.List;

public class HashTableOperations {

  public static void operations() {
    System.out.println("Linked Map: ");
    operations(new LinkedMap<>());
    System.out.println("\nHash Table: ");
    operations(new HashTable<>());
  }

  private static void operations(Map<Integer, String> map) {
    List<String> names = List.of(
      "Tanjiro",
      "Nezuko",
      "Zenitsu",
      "Inosuke",
      "Giyu",
      "Shinobu",
      "Rengoku",
      "Tengen",
      "Muichiro",
      "Mitsuri",
      "Obanai",
      "Sanemi",
      "Gyomei"
    );
    // insert
    for (int i = 0; i < names.size(); i++) {
      map.put(i + 1, names.get(i));
    }
    // fetch
    System.out.println("Get 1:   " + map.get(1));
    System.out.println("Get 2:   " + map.get(2));
    System.out.println("Get 3:   " + map.get(3));
    System.out.println("Get 4:   " + map.get(4));
    System.out.println("Get 10:  " + map.get(10));
    System.out.println("Get 11:  " + map.get(11));
    System.out.println("Get 12:  " + map.get(12));
    System.out.println("Get 13:  " + map.get(13));
    // search
    System.out.println("Find 7:  " + map.find(7));
    System.out.println("Find 14: " + map.find(14));
  }
}
