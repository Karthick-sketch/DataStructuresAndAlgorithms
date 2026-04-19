package datastructures.nonlinear.tree.trie;

import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

class TrieNode {

  private char character;
  private boolean end;
  private List<TrieNode> children;

  TrieNode() {
    initiate('\0');
  }

  TrieNode(char character) {
    initiate(character);
  }

  private void initiate(char character) {
    this.character = character;
    this.end = false;
    this.children = new LinkedList<>();
  }

  char getCharacter() {
    return character;
  }

  void setCharacter(char character) {
    this.character = character;
  }

  boolean isEnd() {
    return end;
  }

  void setEnd(boolean end) {
    this.end = end;
  }

  List<TrieNode> getChildren() {
    return children;
  }

  void setChildren(List<TrieNode> children) {
    this.children = children;
  }
}
