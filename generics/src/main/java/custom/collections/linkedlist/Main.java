package custom.collections.linkedlist;

public class Main {
  public static void main(String[] args) {

    // List<Integer> numeroList = new LinkedList<>();
    // numeroList.add(10);
    // numeroList.add(10);
    // numeroList.set(0, 15);

    // System.out.println("Números" + numeroList);

    // CustomLinkedList<String> list = new CustomLinkedList<>();
    // list.add("Ramses");
    // list.add("Derek");
    // list.add("Joel");

    // list.pintCustomLinkedList();

    CustomLinkedList<Integer> numberList = new CustomLinkedList<>();
    numberList.add(10);
    numberList.add(45);
    numberList.add(30);
    numberList.add(55);
    numberList.pintCustomLinkedList();
    numberList.delete(10);
    numberList.delete(55);
    System.out.println("New List");
    numberList.pintCustomLinkedList();

  }

}
