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
    System.out.print("Select an option:");
    return scanner.nextInt();
  }

  @Override
  public String askId() {
    System.out.print("Id:");
    return scanner.next();
  }

  @Override
  public String askName() {
    System.out.print("Name:");
    return scanner.next();
  }

  @Override
  public Double askGrade() {
    System.out.println("Name:");
    return Double.parseDouble(scanner.next());
  }

  @Override
  public Integer askAttendance() {
    return Integer.parseInt(scanner.next());
  }

  @Override
  public void showMessage(String message) {
    System.out.println();
    System.out.println(message);
  }

  @Override
  public void showStudents(List<?> students) {
    for (Object s : students) {
      System.out.println(s);
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
