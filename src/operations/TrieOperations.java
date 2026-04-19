package operations;

import datastructures.nonlinear.tree.trie.Trie;

public class TrieOperations {

  public static void operations() {
    Trie trie = new Trie();
    System.out.println("Add 'fastest'");
    trie.add("fastest");
    System.out.println("Add 'faster'");
    trie.add("faster");
    System.out.println("Add 'fast'");
    trie.add("fast");
    System.out.println(trie.get());
    System.out.println();

    System.out.println("Find 'f' -> " + trie.find("f"));
    System.out.println("Find 'fa' -> " + trie.find("fa"));
    System.out.println("Find 'fas' -> " + trie.find("fas"));
    System.out.println("Find 'fast' -> " + trie.find("fast"));
    System.out.println("Find 'faste' -> " + trie.find("faste"));
    System.out.println("Find 'faster' -> " + trie.find("faster"));
    System.out.println("Find 'fastes' -> " + trie.find("fastes"));
    System.out.println("Find 'fastest' -> " + trie.find("fastest"));
    System.out.println("Find 'slow' -> " + trie.find("slow"));
    System.out.println();

    System.out.println("Add 'slow'");
    trie.add("slow");
    System.out.println("Find 'slow' -> " + trie.find("slow"));
    System.out.println(trie.get());
    System.out.println();

    System.out.println("Delete 'fast' -> " + trie.remove("fast"));
    System.out.println(trie.get());
    System.out.println("Delete 'faster' -> " + trie.remove("faster"));
    System.out.println(trie.get());
    System.out.println("Delete 'fastest' -> " + trie.remove("fastest"));
    System.out.println(trie.get());
    System.out.println("Delete 'slow' -> " + trie.remove("slow"));
    System.out.println(trie.get());
    System.out.println("Delete 'slower' -> " + trie.remove("slower"));
    System.out.println(trie.get());
  }
}
