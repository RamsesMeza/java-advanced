package custom.collections.linkedlist;

import java.util.Objects;

import custom.collections.Node;

public class CustomLinkedList<T> {
  private Node<T> head;

  public CustomLinkedList() {
    this.head = null;
  }

  public void add(T value) {

    Node<T> node = new Node<>(value);

    if (this.head == null) {
      this.head = node;
    } else {

      Node<T> currentNode = this.head;
      while (currentNode.getNextNode() != null) {
        currentNode = currentNode.getNextNode();
      }
      currentNode.setNextNode(node);

    }
  }

  public void pintCustomLinkedList() {
    Node<T> currentNode = this.head;
    while (currentNode != null) {
      System.out.println(currentNode.getValue());
      currentNode = currentNode.getNextNode();
    }

  }

  public void update(T oldValue, T newValue) {
    Node<T> currentNode = this.head;
    while (currentNode != null) {

      if (currentNode.getValue() == oldValue) {
        currentNode.setValue(newValue);
      }
      currentNode = currentNode.getNextNode();
    }
  }

  public void delete(T value) {

    if (this.head == null) {
      return;
    }

    if (this.head.getValue() == value) {
      this.head = this.head.getNextNode();
      return;
    }

    Node<T> currentNode = this.head;
    Node<T> nextNode = this.head.getNextNode();

    while (nextNode != null) {

      if (Objects.equals(nextNode.getValue(), value)) {
        currentNode.setNextNode(nextNode.getNextNode());
        return;
      }

      nextNode = nextNode.getNextNode();
      currentNode = currentNode.getNextNode();
    }

  }

  @Override
  public String toString() {
    return "CustomLinkedList [head=" + head + "]";
  }

}
