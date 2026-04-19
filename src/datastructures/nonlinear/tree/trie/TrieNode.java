package datastructures.nonlinear.tree.trie;

import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

class TrieNode {

  private char character;
  private boolean end;
  private List<TrieNode> alphabets;

  TrieNode() {
    initiate('\0');
  }

  TrieNode(char character) {
    initiate(character);
  }

  private void initiate(char character) {
    this.character = character;
    this.end = false;
    this.alphabets = new LinkedList<>();
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

  List<TrieNode> getAlphabets() {
    return alphabets;
  }

  void setAlphabets(List<TrieNode> alphabets) {
    this.alphabets = alphabets;
  }
}
