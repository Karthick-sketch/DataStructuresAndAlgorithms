package datastructures.nonlinear.tree.trie;

import datastructures.linear.list.List;

public class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  // ----- public methods ----------------------------------------

  public void add(String word) {
    if (!word.matches("[a-zA-Z]+")) {
      System.out.println("Not a valid word");
      return;
    }

    word = word.toUpperCase();
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char character = word.charAt(i);
      List<TrieNode> alphabets = current.getAlphabets();
      TrieNode node = getTrieNode(character, alphabets);
      if (node == null) {
        node = new TrieNode(character);
        alphabets.add(node);
        if (i == word.length() - 1) {
          node.setEnd(true);
        }
      }
      current = node;
    }
  }

  public boolean find(String word) {
    if (!word.matches("[a-zA-Z]+")) {
      System.out.println("Not a valid word");
      return false;
    }

    word = word.toUpperCase();
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char character = word.charAt(i);
      for (int j = 0; j < current.getAlphabets().size(); j++) {
        // TODO
      }
    }

    return false;
  }

  // ----- private methods ----------------------------------------

  private TrieNode getTrieNode(char character, List<TrieNode> alphabets) {
    for (int i = 0; i < alphabets.size(); i++) {
      TrieNode current = alphabets.get(i);
      if (character == current.getCharacter()) {
        return current;
      }
    }
    return null;
  }
}
