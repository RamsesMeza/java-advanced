package com.students.console.register.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  public List<Student> getAll() {
    return new ArrayList<>(this.students.values());
  }

}
