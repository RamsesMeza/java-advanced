package custom.collections.queue;

import custom.collections.Node;

public class CustomQueue<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public CustomQueue() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void add(T value) {
    // Enqueue
    Node<T> newNode = new Node<>(value);

    if (this.isEmpty()) {
      this.tail = newNode;
      this.head = newNode;
      this.size++;
      return;
    }

    Node<T> temp = this.tail;
    this.tail = newNode;
    temp.setNextNode(newNode);

    this.size++;
  }

  // Dequeue
  public T remove() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("The queue is empty");
    }

    T removed = this.head.getValue();

    if (this.head == this.tail) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = this.head.getNextNode();
    }

    // if (this.head.getNextNode() == null) {
    // this.head = this.tail;
    // this.size--;
    // return removed;

    // }

    this.size--;
    return removed;
  }

  public T peek() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("The queue is empty");
    }
    return this.head.getValue();
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public String toString() {
    return "CustomQueue [head=" + head + ", tail=" + tail + ", size=" + size + "]";
  }

}
