package com.students.console.register.repository;

import java.util.List;
import java.util.Optional;

import com.students.console.register.model.Student;

public interface StudentRepository {
  Student add(Student student);

  Optional<Student> findStudentById(String id);

  List<Student> getAll();

}
