package operations;

import datastructures.nonlinear.tree.trie.Trie;

public class TrieOperations {

  public static void operations() {
    Trie trie = new Trie();
    trie.add("fast");
    trie.add("faster");
    trie.add("fastest");

    System.out.println("f -> " + trie.find("f"));
    System.out.println("fa -> " + trie.find("fa"));
    System.out.println("fas -> " + trie.find("fas"));
    System.out.println("fast -> " + trie.find("fast"));
    System.out.println("faste -> " + trie.find("faste"));
    System.out.println("faster -> " + trie.find("faster"));
    System.out.println("fastes -> " + trie.find("fastes"));
    System.out.println("fastest -> " + trie.find("fastest"));
    System.out.println("slow -> " + trie.find("slow"));

    trie.get().forEach(System.out::println);

    trie.add("slow");
    System.out.println("slow -> " + trie.find("slow"));
    trie.get().forEach(System.out::println);
  }
}
