package com.students.console.register.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.students.console.register.dto.RegisteStudentDTO;
import com.students.console.register.model.Student;
import com.students.console.register.repository.StudentRepository;

import exceptions.StudentDomainException;
import exceptions.StudentException;

public class StudentService {

  private StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student registerStudent(RegisteStudentDTO student) throws StudentDomainException, StudentException {
    Student currentStudent = this.studentRepository.findStudentById(student.id());

    if (currentStudent != null) {
      throw new StudentException("The id was used for other student, try again!");
    }

    Student newStudent = new Student(student.id(), student.name(), student.grade(), student.attendance());
    return this.studentRepository.add(newStudent);
  }

  public Student searchStudentById(String id) {
    Student student = this.studentRepository.findStudentById(id);

    if (student == null) {
      throw new NoSuchElementException("Student was not found");
    }
    return student;
  }

  public List<Student> getListOfStudents() {
    return this.studentRepository.getAll();
  }

}
