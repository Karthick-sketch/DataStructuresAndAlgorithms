package datastructures.nonlinear.tree.trie;

import datastructures.linear.list.List;

public class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  // ----- public methods ----------------------------------------

  public void add(String word) {
    if (isNotWord(word)) {
      return;
    }

    word = word.toUpperCase();
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      List<TrieNode> alphabets = current.getAlphabets();
      TrieNode node = getTrieNode(word.charAt(i), alphabets);
      if (node != null) {
        current = node;
      } else {
        for (int j = i; j < word.length(); j++) {
          node = new TrieNode(word.charAt(j));
          alphabets.add(node);
          alphabets = node.getAlphabets();
        }
        // last character of the word
        node.setEnd(true);
        break;
      }
    }
  }

  public boolean find(String word) {
    if (isNotWord(word)) {
      return false;
    }

    word = word.toUpperCase();
    TrieNode current = root;
    TrieNode node = null;
    for (int i = 0; i < word.length(); i++) {
      List<TrieNode> alphabets = current.getAlphabets();
      node = getTrieNode(word.charAt(i), alphabets);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return node != null && node.isEnd();
  }

  // ----- private methods ----------------------------------------

  private boolean isNotWord(String word) {
    if (word.matches("[a-zA-Z]+")) {
      return false;
    }
    System.out.println("Not a word");
    return true;
  }

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
