package com.students.console.register.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.students.console.register.dto.RegisteStudentDTO;
import com.students.console.register.model.Student;
import com.students.console.register.repository.StudentRepository;

public class StudentService {

  private StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student registerStudent(RegisteStudentDTO student) {
    Student newStudent = new Student(student.id(), student.name(), student.grade(), student.attendance());
    return this.studentRepository.add(newStudent);
  }

  public Student searchStudentById(String id) {
    Optional<Student> student = this.studentRepository.findStudentById(id);

    if (student.isEmpty()) {
      throw new NoSuchElementException("Student was not found");
    }
    return student.get();
  }

  public List<Student> getListOfStudents() {
    return this.studentRepository.getAll();
  }

}
