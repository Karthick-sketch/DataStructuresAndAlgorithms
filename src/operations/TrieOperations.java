package operations;

import datastructures.nonlinear.tree.trie.Trie;

public class TrieOperations {

  public static void operations() {
    Trie trie = new Trie();
    trie.add("fast");
    trie.add("faster");
    trie.add("fastest");

    System.out.println("fast -> " + trie.find("fast"));
    System.out.println("slow -> " + trie.find("slow"));
    System.out.println("faster -> " + trie.find("faster"));
    System.out.println("slower -> " + trie.find("slower"));
    System.out.println("fastest -> " + trie.find("fastest"));
    System.out.println("slowest -> " + trie.find("slowest"));
  }
}
