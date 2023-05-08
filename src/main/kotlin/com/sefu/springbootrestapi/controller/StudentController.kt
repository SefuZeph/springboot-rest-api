package com.sefu.springbootrestapi.controller

import com.sefu.springbootrestapi.bean.Student
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
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

    // http://localhost:8080/student/1/john
    @GetMapping("student/{id}/{first-name}")
    fun studentPathVariable(
        @PathVariable("id") studentId: Long, @PathVariable("first-name") studentName: String
    ): Student {
        return Student(studentId, studentName, "Doe")
    }

    // http://localhost:8080/students/query?id=3&name=zeph
    @GetMapping("students/query")
    fun queryStudentParams(@RequestParam id: Long, @RequestParam name: String): Student {
        return Student(id, name, "Doe")
    }


    // spring boot rest api that handles http post
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createStudent(@RequestBody student: Student): Student {
        println("UserId ${student.id}")
        println("First name ${student.firstName}")
        println("Last name ${student.lastName}")
        return student
    }

}