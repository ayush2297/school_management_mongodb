package learn.project.mongodb.service

import learn.project.mongodb.model.Student
import learn.project.mongodb.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
  private val studentRepository: StudentRepository
) {
  fun createStudent(student: Student): Student {
    return studentRepository.save(student)
  }
}