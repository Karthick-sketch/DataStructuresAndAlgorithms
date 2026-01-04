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

  private static void operations(Map<String, String> map) {
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
    List<String> breathing = List.of(
      "Hinokami Kagura",
      "Blood Demon Art",
      "Thunder Breathing",
      "Beast Breathing",
      "Water Breathing",
      "Insect Breathing",
      "Flame Breathing",
      "Sound Breathing",
      "Mist Breathing",
      "Love Breathing",
      "Serpent Breathing",
      "Wind Breathing",
      "Stone Breathing"
    );
    // insert
    for (int i = 0; i < names.size(); i++) {
      map.put(names.get(i), breathing.get(i));
    }
    // fetch
    int[] fetchKeys = { 0, 1, 2, 3, 9, 10, 11, 12 };
    for (int k : fetchKeys) {
      String key = names.get(k);
      System.out.println(key + " : " + map.get(key));
    }
    // search
    System.out.println("Find Nezuko:  " + map.find("Nezuko"));
    System.out.println("Find Muzan: " + map.find("Muzan"));
    // clear
    map.clear();
    System.out.println("Cleared: " + map.getKeys());
  }
}
