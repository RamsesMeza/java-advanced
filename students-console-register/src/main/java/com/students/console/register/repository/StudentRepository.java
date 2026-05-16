package com.students.console.register.repository;

import java.util.List;

import com.students.console.register.model.Student;

public interface StudentRepository {
  Student add(Student student);

  Student findStudentById(String id);

  List<Student> getAll();

}
