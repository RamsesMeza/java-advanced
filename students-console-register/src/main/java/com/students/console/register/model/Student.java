package com.students.console.register.model;

import java.util.Objects;

public class Student {
  private String id;
  private String name;
  private Double grade;
  private Integer attendance;

  public Student(String id, String name, Double grade, Integer attendance) {
    this.id = id;
    this.name = name;
    this.grade = grade;
    this.attendance = attendance;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) throws Exception {

    Objects.requireNonNull(id, "Property Id can't be null");

    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    Objects.requireNonNull(name, "Property name can't be null");
    this.name = name;
  }

  public Double getGrade() {
    return grade;
  }

  public void setGrade(Double grade) throws Exception {

    Objects.requireNonNull(grade, "Property grade can't be null");

    boolean isOnRange = grade >= 0 && grade <= 100;

    if (!isOnRange) {
      throw new Exception("Grade must be a number between 0 and 100");
    }

    this.grade = grade;
  }

  public Integer getAttendance() {
    return attendance;
  }

  public void setAttendance(Integer attendance) throws Exception {

    Objects.requireNonNull(attendance, "Property attendance can't be null");

    boolean isOnRange = attendance >= 0 && attendance <= 100;

    if (!isOnRange) {
      throw new Exception("Attendance must be a number between 0 and 100");
    }

    this.attendance = attendance;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", attendance=" + attendance + "]";
  }

}
