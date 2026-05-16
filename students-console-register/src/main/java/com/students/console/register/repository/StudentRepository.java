package com.students.console.register.repository;

import java.util.Map;

import com.students.console.register.model.Student;

public interface StudentRepository {
  Student add(Student student);

  Student findStudentById(String id);

  Map<String, Student> getAll();

}
