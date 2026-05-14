package com.students.console.register.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.students.console.register.model.Student;

public class StudentRepositoryMemory implements StudentRepository {
  private final List<Student> students;

  public StudentRepositoryMemory() {
    this.students = new ArrayList<>();
  }

  public Student add(Student student) {
    students.add(student);
    return student;
  }

  public Optional<Student> findStudentById(String id) {
    return students.stream().filter(s -> s.getId().equals(id)).findFirst();
  }

  public List<Student> getAll() {
    return new ArrayList<>(this.students);
  }

}
