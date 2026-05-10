package wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {
  public static void main(String[] args) {
    List<String> names = new ArrayList<>();

    names.add("Ramses");
    names.add("Joel");

    List<Integer> numbers = new ArrayList<>();
    numbers.add(10);
    numbers.add(8);

    List<Integer> numbersTwo = new ArrayList<>();
    numbersTwo.add(10);
    numbersTwo.add(8);

    printListTwo(numbers);

    printList(names);
    printList(numbers);

    average(numbers);
    addToList(numbers);
    average(numbers);
    printList(numbers);

  }

  // Im only gonna reed
  public static void printList(List<?> list) {
    for (Object object : list) {
      System.out.println(object);
    }
  }

  public static <T> void printListTwo(List<T> list) {
    for (T object : list) {
      System.out.println(object);
    }
  }

  public static void average(List<? extends Number> list) {
    Double result = 0.0;
    for (Number number : list) {
      result += number.doubleValue();
    }

    Double average = result / list.size();
    System.out.println("Average: " + average);
  }

  public static void addToList(List<? super Integer> list) {
    list.add(10);
    list.add(10);
  }

  public static <T> T getFirst(List<T> list) {
    return list.get(0);
  }
}

// NOTE: Necesito conservar el tipo exacto para devolverlo, compararlo,
// agregarlo o relacionarlo con otro parámetro.
