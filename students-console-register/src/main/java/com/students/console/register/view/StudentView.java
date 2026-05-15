package com.students.console.register.view;

import java.util.List;

import com.students.console.register.model.Student;

public interface StudentView {
  void showMenu();

  int getOption();

  String askId();

  String askName();

  Double askGrade();

  Integer askAttendance();

  void showStudents(List<?> students);

  void showMessage(String message);

  void showStudent(Student student);
}
