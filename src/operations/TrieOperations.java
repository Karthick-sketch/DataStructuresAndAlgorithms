package operations;

import datastructures.nonlinear.tree.trie.Trie;

public class TrieOperations {

  private static final String[] TO_ADD = {
    "apple",
    "app",
    "application",
    "apply",
    "apt",
    "bat",
    "bath",
    "batman",
    "cat",
    "car",
    "card",
    "care",
    "careful",
    "do",
    "dog",
    "door",
    "done",
    "he",
    "her",
    "here",
    "hero",
    "test",
    "testing",
    "z",
    "zoom",
  };

  private static final String[] TO_FIND = {
    "app",
    "apple",
    "card",
    "her",
    "z",
    "ap",
    "cars",
    "cares",
    "bad",
    "ze",
  };

  private static final String[] TO_SUGGESTION = {
    "app",
    "car",
    "do",
    "he",
    "b",
    "tri",
  };

  private static final String[] TO_REMOVE = {
    "app",
    "her",
    "careful",
    "z",
    "bath",
  };

  public static void operations() {
    Trie trie = new Trie();
    for (String word : TO_ADD) {
      System.out.println("Add '" + word + "'");
      trie.add(word);
    }
    System.out.println(trie.get());
    System.out.println();

    for (String word : TO_FIND) {
      System.out.println("Find '" + word + "' -> " + trie.find(word));
    }
    System.out.println();

    for (String word : TO_SUGGESTION) {
      System.out.println(
        "Suggestion for '" + word + "' -> " + trie.suggest(word)
      );
    }
    System.out.println();

    System.out.println(trie.get());
    for (String word : TO_REMOVE) {
      System.out.println("Remove '" + word + "' -> " + trie.remove(word));
      System.out.println(trie.get());
    }
    System.out.println();

    System.out.println("Clear Trie");
    trie.clear();
    System.out.println(trie.get());
    System.out.println();
  }
}
