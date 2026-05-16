package com.students.console.register.model;

import com.students.console.register.exceptions.StudentDomainException;

public class Student {
  private String id;
  private String name;
  private Double grade;
  private Integer attendance;

  public Student(String id, String name, Double grade, Integer attendance) throws StudentDomainException {

    if (id == null || id.isBlank()) {
      throw new StudentDomainException("Property Id can't be null");
    }

    if (name == null || name.isBlank()) {
      throw new StudentDomainException("Property Name can't be null");
    }

    if (grade == null) {
      throw new StudentDomainException("Property Grade can't be null");
    }

    boolean gradeOnRange = grade >= 0 && grade <= 10;

    if (!gradeOnRange) {
      throw new StudentDomainException("Grade must be a number between 0 and 10");
    }

    if (attendance == null) {
      throw new StudentDomainException("Property Grade can't be null");
    }

    boolean attendanceOnRange = attendance >= 0 && attendance <= 100;

    if (!attendanceOnRange) {
      throw new StudentDomainException("Attendance must be a number between 0 and 100");
    }

    this.id = id;
    this.name = name;
    this.grade = grade;
    this.attendance = attendance;
  }

  public boolean isApproved() {
    if (this.grade == null || this.attendance == null) {
      return false;
    }
    return this.grade >= 6 && this.attendance >= 80;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) throws StudentDomainException {

    if (id == null || id.isBlank()) {
      throw new StudentDomainException("Property Id can't be null");
    }

    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) throws StudentDomainException {
    if (name == null || name.isBlank()) {
      throw new StudentDomainException("Property Name can't be null");
    }
    this.name = name;
  }

  public Double getGrade() {
    return grade;
  }

  public void setGrade(Double grade) throws StudentDomainException {

    if (grade == null) {
      throw new StudentDomainException("Property Grade can't be null");
    }

    boolean isOnRange = grade >= 0 && grade <= 10;

    if (!isOnRange) {
      throw new StudentDomainException("Grade must be a number between 0 and 100");
    }

    this.grade = grade;
  }

  public Integer getAttendance() {
    return attendance;
  }

  public void setAttendance(Integer attendance) throws StudentDomainException {

    if (grade == null) {
      throw new StudentDomainException("Property Grade can't be null");
    }

    boolean isOnRange = attendance >= 0 && attendance <= 100;

    if (!isOnRange) {
      throw new StudentDomainException("Attendance must be a number between 0 and 100");
    }

    this.attendance = attendance;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", attendance=" + attendance + "]";
  }

}
