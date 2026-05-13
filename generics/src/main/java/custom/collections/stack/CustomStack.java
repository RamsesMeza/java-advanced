package custom.collections.stack;

import custom.collections.Node;

public class CustomStack<T> {

  private Node<T> top;

  public CustomStack() {
    this.top = null;
  }

  public void push(T value) {

    Node<T> newNode = new Node<>(value);

    if (this.top == null) {
      this.top = newNode;
      return;
    }

    newNode.setNextNode(this.top);
    this.top = newNode;

  }

  public T pop() {
    T poppedValue = this.top.getValue();
    this.top = this.top.getNextNode();
    return poppedValue;
  }

  public T peek() {
    return this.top.getValue();
  }

  public boolean isEmpty() {
    return this.top == null;
  }

  public int size() {

    int counter = 0;
    Node<T> currentNode = this.top;
    while (currentNode != null) {
      counter++;
      currentNode = currentNode.getNextNode();
    }
    return counter;
  }

  @Override
  public String toString() {
    return "CustomStack [top=" + top + "]";
  }

}
