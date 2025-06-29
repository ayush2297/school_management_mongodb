package learn.project.mongodb.service

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import learn.project.mongodb.model.Department
import learn.project.mongodb.model.Student
import learn.project.mongodb.model.Subject
import learn.project.mongodb.repository.StudentRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class StudentServiceTest {
  @InjectMockKs
  private lateinit var studentService: StudentService

  @MockK
  private lateinit var studentRepository: StudentRepository

  @Test
  internal fun `should create a student and save in the DB`() {
    val student = Student(
      id = "1",
      name = "John Doe",
      email = "",
      department = Department(
        departmentName = "Computer Science",
        location = "Building A"
      ),
      subjects = listOf(
        Subject(
          subjectName = "DSA",
          marksObtained = 85
        ),
        Subject(
          subjectName = "OOPs",
          marksObtained = 90
        )
      ),
    )

    every { studentRepository.save(any<Student>()) } returns student

    val savedStudent = studentService.createStudent(student)

    assertEquals(student, savedStudent)
  }
}