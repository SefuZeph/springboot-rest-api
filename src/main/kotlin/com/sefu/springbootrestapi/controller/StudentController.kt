package com.sefu.springbootrestapi.controller

import com.sefu.springbootrestapi.bean.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    fun getStudent(): Student {
        return Student(1, "John", "Doe")
    }

    // http://localhost:8080/students
    @GetMapping("students")
    fun getStudents(): MutableList<Student> {
        val student = mutableListOf<Student>()
        student.add(Student(1, "John", "Doe"))
        student.add(Student(2, "Jane", "Doe"))
        return student
    }
}