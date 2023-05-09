package com.sefu.springbootrestapi.controller

import com.sefu.springbootrestapi.bean.Student
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    fun getStudent(): ResponseEntity<Student> {
        val student = Student(1, "John", "Doe")
        return ResponseEntity.ok().header("custom-header", "sefu").body(student)
    }

    // http://localhost:8080/students
    @GetMapping("students")
    fun getStudents(): ResponseEntity<MutableList<Student>> {
        val student = mutableListOf<Student>()
        student.add(Student(1, "John", "Doe"))
        student.add(Student(2, "Jane", "Doe"))
        return ResponseEntity.ok(student)
    }

    // http://localhost:8080/student/1/john
    @GetMapping("student/{id}/{first-name}")
    fun studentPathVariable(
        @PathVariable("id") studentId: Long, @PathVariable("first-name") studentName: String
    ): ResponseEntity<Student> {
        val student = Student(studentId, studentName, "Doe")
        return ResponseEntity.ok(student)
    }

    // http://localhost:8080/students/query?id=3&name=zeph
    @GetMapping("students/query")
    fun queryStudentParams(@RequestParam id: Long, @RequestParam name: String): Student {
        return Student(id, name, "Doe")
    }

    // Create user
    @PostMapping("student/create")
    fun studentCreate(@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity(student, HttpStatus.CREATED)
    }

    // Update user

    @PutMapping("student/{id}/update")
    fun updateStudent(@RequestBody student: Student, @PathVariable("id") studentId: Long): ResponseEntity<Student> {
        return ResponseEntity.ok(student)
    }

    // Delete user

    @DeleteMapping("student/{id}/delete")
    fun deleteStudent(@PathVariable("id") studentId: Int): String {
        return "Student successfully deleted!"
    }


}