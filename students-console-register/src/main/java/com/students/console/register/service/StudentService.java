package com.students.console.register.service;

import java.util.Objects;

import com.students.console.register.model.Student;
import com.students.console.register.repository.StudentRepositoryMemory;

public class StudentService {

  private StudentRepositoryMemory studentRepositoryMemory;

  public StudentService() {
    this.studentRepositoryMemory = new StudentRepositoryMemory();
  }

  public void registerStudent(Student student) {

    Objects.requireNonNull(student, "Student can be null");

    this.studentRepositoryMemory.add(student);
  }

}
