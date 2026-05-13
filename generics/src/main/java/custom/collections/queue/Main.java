package custom.collections.queue;

public class Main {
  public static void main(String[] args) {
    CustomQueue<Integer> numberList = new CustomQueue<>();

    numberList.add(10);
    numberList.add(45);
    numberList.add(70);
    System.out.println(numberList);

    try {
      System.out.println("Peek: " + numberList.peek());

      System.out.println("Remove: " + numberList.remove());
      System.out.println("Remove: " + numberList.remove());
      System.out.println(numberList);

      System.out.println("Remove: " + numberList.remove());
      System.out.println(numberList);

      System.out.println("Remove: " + numberList.remove());

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(numberList);
  }
}
