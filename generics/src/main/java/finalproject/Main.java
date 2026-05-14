package finalproject;

public class Main {
  public static void main(String[] args) {

    DataStore<User, String> users = new DataStore<>();

    users.add("1", new User("1", "Ramses"));
    users.add("2", new User("2", "Derek"));
    users.add("3", new User("3", "Joel"));
    users.add("4", new User("4", "Patrick"));

    System.out.println(users);

    users.remove("2");
    System.out.println(users);

    System.out.println(users.find("1"));

    System.out.println(users.getAll());
  }
}
