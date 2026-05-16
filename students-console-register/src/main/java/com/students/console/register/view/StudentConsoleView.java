package com.students.console.register.view;

import java.util.List;
import java.util.Scanner;

import com.students.console.register.model.Student;

public class StudentConsoleView implements StudentView {

  private final Scanner scanner;

  public StudentConsoleView() {
    this.scanner = new Scanner(System.in);
  }

  @Override
  public void showMenu() {
    System.out.println();
    System.out.println("MENU");
    System.err.println("1. Register student");
    System.out.println("2. Find student");
    System.out.println("3. List students");
    System.out.println("4. Leave");
  }

  @Override
  public int getOption() {

    while (true) {
      try {
        System.out.print("Select an option:");
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Option must be a valid number.");

      }
    }

  }

  @Override
  public String askId() {
    System.out.print("Id:");
    return scanner.nextLine();
  }

  @Override
  public String askName() {
    System.out.print("Name:");
    String name = scanner.nextLine();
    return name;
  }

  @Override
  public Double askGrade() {
    while (true) {

      try {
        System.out.print("Grade:");
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Grade must be a valid number.");
      }

    }
  }

  @Override
  public Integer askAttendance() {
    while (true) {
      try {
        System.out.print("Attendance:");
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Attendance must be a valid number.");
      }
    }
  }

  @Override
  public void showMessage(String message) {
    System.out.println();
    System.out.println(message);
  }

  @Override
  public void showStudents(List<Student> students) {

    if (students.size() == 0) {
      System.out.println("\nThere are no students registered");
    } else {

      for (Student s : students) {
        System.out.println("Id: " + s.getId());
        System.out.println("Name:" + s.getName());
        System.out.println("Grade: " + s.getGrade());
        System.out.println("Attendance: " + s.getAttendance());

        String state = s.isApproved() ? "Approved" : "Failed";
        System.out.println("State: " + state);
      }

    }
  }

  @Override
  public void showStudent(Student student) {
    System.out.println();
    System.out.println("Student");
    System.out.println("Id: " + student.getId());
    System.out.println("Name:" + student.getName());
    System.out.println("Grade: " + student.getGrade());
    System.out.println("Attendance: " + student.getAttendance());

    String state = student.isApproved() ? "Approved" : "Failed";
    System.out.println("State: " + state);
  }

}
