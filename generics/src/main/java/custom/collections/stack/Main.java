package custom.collections.stack;

public class Main {
  public static void main(String[] args) {
    CustomStack<Integer> numberStack = new CustomStack<>();

    numberStack.push(10);
    numberStack.push(45);
    numberStack.push(62);

    System.out.println(numberStack.size());
    System.out.println(numberStack.pop());
    System.out.println(numberStack.size());

    System.out.println(numberStack);
    System.out.println(numberStack.peek());
    System.out.println(numberStack.pop());

  }

}
