package custom.collections;

public class Main {
  public static void main(String[] args) {

    CustomLinkedList<String> list = new CustomLinkedList<>();
    list.add("Ramses");
    list.add("Derek");
    list.add("Joel");

    list.pintCustomLinkedList();

    CustomLinkedList<Integer> numberList = new CustomLinkedList<>();
    numberList.add(10);
    numberList.add(45);
    numberList.add(30);
    numberList.add(55);

    numberList.pintCustomLinkedList();

  }

}
