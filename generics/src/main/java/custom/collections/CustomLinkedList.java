package custom.collections;

import java.util.Objects;

public class CustomLinkedList<T> {
  private Node<T> head;

  public CustomLinkedList() {
    this.head = null;
  }

  public void add(T value) {

    Node<T> node = new Node<>(value);

    if (Objects.isNull(this.head)) {
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

  @Override
  public String toString() {
    return "CustomLinkedList [head=" + head + "]";
  }

}
