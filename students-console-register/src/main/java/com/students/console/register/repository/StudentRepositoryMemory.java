package com.students.console.register.repository;

import java.util.HashMap;
import java.util.Map;

import com.students.console.register.model.Student;

public class StudentRepositoryMemory implements StudentRepository {
  private final Map<String, Student> students;

  public StudentRepositoryMemory() {
    this.students = new HashMap<>();
  }

  public Student add(Student student) {
    students.put(student.getId(), student);
    return student;
  }

  public Student findStudentById(String id) {
    return students.get(id);
  }

  public Map<String, Student> getAll() {
    return new HashMap<>(this.students);
  }

}
