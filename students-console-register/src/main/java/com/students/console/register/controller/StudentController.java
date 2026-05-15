package com.students.console.register.controller;

import com.students.console.register.dto.RegisteStudentDTO;
import com.students.console.register.model.Student;
import com.students.console.register.service.StudentService;
import com.students.console.register.view.StudentView;

public class StudentController {
  private StudentView studentView;
  private StudentService studentService;

  public StudentController(StudentView studentView, StudentService studentService) {
    this.studentView = studentView;
    this.studentService = studentService;
  }

  public void registerStudent() {
    try {
      String id = studentView.askId();
      String name = studentView.askName();
      RegisteStudentDTO student = new RegisteStudentDTO(id, name, null, null);
      studentService.registerStudent(student);
      this.studentView.showMessage("Student registered!");
    } catch (Exception e) {
      this.studentView.showMessage(e.getMessage());
    }
  }

  public void findStudent() {
    try {
      String id = this.studentView.askId();
      Student student = this.studentService.searchStudentById(id);
      this.studentView.showStudent(student);
    } catch (Exception e) {
      this.studentView.showMessage(e.getMessage());
    }

  }

  public void listStudents() {
    this.studentView.showStudents(this.studentService.getListOfStudents());
  }

  public void start() {

    int option;
    do {
      studentView.showMenu();
      option = studentView.getOption();

      switch (option) {
        case 1:
          this.registerStudent();
          break;
        case 2:
          this.findStudent();
          break;
        case 3:
          this.listStudents();
          break;
        case 4:
          option = 4;
          this.studentView.showMessage("Thanks to use the program!");
          break;

        default:
          this.studentView.showMessage("Try again, select a valid option");
          break;
      }

    } while (option != 4);

  }

}
