package com.students.console.register;

import com.students.console.register.controller.StudentController;
import com.students.console.register.repository.StudentRepositoryMemory;
import com.students.console.register.service.StudentService;
import com.students.console.register.view.StudentConsoleView;

public class App {
    public static void main(String[] args) {

        StudentRepositoryMemory studentRepositoryMemory = new StudentRepositoryMemory();

        StudentConsoleView studentConsoleView = new StudentConsoleView();
        StudentService studentService = new StudentService(studentRepositoryMemory);

        StudentController studentController = new StudentController(studentConsoleView, studentService);

        studentController.start();
    }
}
