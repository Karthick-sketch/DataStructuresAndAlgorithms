package datastructures.nonlinear.tree.trie;

import datastructures.linear.Stack;
import datastructures.linear.list.LinkedList;
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
    TrieNode node = null;
    for (int i = 0; i < word.length(); i++) {
      List<TrieNode> children = current.getChildren();
      node = getTrieNode(word.charAt(i), children);
      if (node != null) {
        current = node;
      } else {
        for (int j = i; j < word.length(); j++) {
          node = new TrieNode(word.charAt(j));
          children.add(node);
          children = node.getChildren();
        }
        // last character of the word
        break;
      }
    }
    if (node != null) {
      node.setEnd(true);
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
      List<TrieNode> children = current.getChildren();
      node = getTrieNode(word.charAt(i), children);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return node != null && node.isEnd();
  }

  public List<String> get() {
    List<String> words = new LinkedList<>();
    root
      .getChildren()
      .forEach(node -> {
        get(node, words, new StringBuilder());
      });
    return words;
  }

  public boolean remove(String word) {
    if (isNotWord(word)) {
      return false;
    }

    word = word.toUpperCase();
    Stack<TrieNode> stack = new Stack<>();
    TrieNode parent = root;
    TrieNode child = null;
    for (int i = 0; i < word.length(); i++) {
      char character = word.charAt(i);
      List<TrieNode> children = parent.getChildren();
      boolean found = false;
      for (int j = 0; j < children.size() && !found; j++) {
        child = children.get(j);
        if (child.getCharacter() == character) {
          stack.push(child);
          parent = child;
          found = true;
        }
      }
      if (!found) {
        return false;
      }
    }

    if (stack.isEmpty()) {
      return false;
    }

    child = stack.pop();
    if (!child.isEnd()) {
      return false;
    } else if (child.getChildren().size() > 0) {
      child.setEnd(false);
      return true;
    }

    while (!stack.isEmpty()) {
      parent = stack.pop();
      parent.getChildren().remove(child);
      child = parent;
      if (child.getChildren().size() > 0) {
        return true;
      }
    }

    root.getChildren().remove(child);
    return true;
  }

  // ----- private methods ----------------------------------------

  private boolean isNotWord(String word) {
    if (word.matches("[a-zA-Z]+")) {
      return false;
    }
    System.out.println("Not a word");
    return true;
  }

  private TrieNode getTrieNode(char character, List<TrieNode> children) {
    for (int i = 0; i < children.size(); i++) {
      TrieNode current = children.get(i);
      if (character == current.getCharacter()) {
        return current;
      }
    }
    return null;
  }

  private void get(TrieNode current, List<String> words, StringBuilder word) {
    word.append(current.getCharacter());
    if (current.isEnd()) {
      words.add(word.toString());
    }
    current
      .getChildren()
      .forEach(node -> {
        get(node, words, new StringBuilder(word));
      });
  }
}
