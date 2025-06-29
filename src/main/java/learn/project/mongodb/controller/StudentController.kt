package learn.project.mongodb.controller

import learn.project.mongodb.model.Student
import learn.project.mongodb.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/student")
class StudentController(private val studentService: StudentService) {

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/add")
  fun createStudent(@RequestBody student: Student): String {
    val createdStudent = studentService.createStudent(student)
    return createdStudent.id
  }
}