package datastructures.linear;

public class DoublyNode<D> {
  private D value;
  private DoublyNode<D> previous;
  private DoublyNode<D> next;

  public DoublyNode(D value) {
    this.value = value;
    this.previous = null;
    this.next = null;
  }

  public D getValue() {
    return value;
  }

  public void setValue(D value) {
    this.value = value;
  }

  public DoublyNode<D> getPrevious() {
    return previous;
  }

  public void setPrevious(DoublyNode<D> previous) {
    this.previous = previous;
  }

  public DoublyNode<D> getNext() {
    return next;
  }

  public void setNext(DoublyNode<D> next) {
    this.next = next;
  }
}
