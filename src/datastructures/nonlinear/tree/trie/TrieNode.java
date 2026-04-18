package datastructures.nonlinear.tree.trie;

import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

public class TrieNode {

  private char character;
  private boolean end;
  private List<TrieNode> alphabets;

  public TrieNode() {
    initiate('\0');
  }

  public TrieNode(char character) {
    initiate(character);
  }

  private void initiate(char character) {
    this.character = character;
    this.end = false;
    this.alphabets = new LinkedList<>();
  }

  public char getCharacter() {
    return character;
  }

  public void setCharacter(char character) {
    this.character = character;
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }

  public List<TrieNode> getAlphabets() {
    return alphabets;
  }

  public void setAlphabets(List<TrieNode> alphabets) {
    this.alphabets = alphabets;
  }
}
