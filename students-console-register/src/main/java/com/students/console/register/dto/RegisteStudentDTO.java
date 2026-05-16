package com.students.console.register.dto;

public record RegisteStudentDTO(
    String id,
    String name,
    Double grade,
    Integer attendance) {

  public RegisteStudentDTO {
    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("Id is required");
    }

    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name is required");
    }

    if (attendance == null) {
      throw new IllegalArgumentException("Attendance is required");
    }

    if (grade == null) {
      throw new IllegalArgumentException("Grade is required");
    }

  }

}
