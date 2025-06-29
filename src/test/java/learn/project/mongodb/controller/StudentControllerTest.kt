package learn.project.mongodb.controller

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import learn.project.mongodb.model.Department
import learn.project.mongodb.model.Student
import learn.project.mongodb.model.Subject
import learn.project.mongodb.service.StudentService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(StudentController::class)
class StudentControllerTest {
  @Autowired
  private lateinit var mockMvc: MockMvc

  @MockkBean
  private lateinit var studentService: StudentService

  @Test
  internal fun `should return the student id when a student is created`() {
    val student = Student(
      id = "1",
      name = "John Doe",
      email = "",
      department = Department(
        departmentName = "Computer Science", location = "Building A"
      ),
      subjects = listOf(
        Subject(
          subjectName = "DSA", marksObtained = 85
        ), Subject(
          subjectName = "OOPs", marksObtained = 90
        )
      ),
    )
//    write above as json
    val studentJson = """
      {
        "id": "1",
        "name": "John Doe",
        "email": "",
        "department": {
          "departmentName": "Computer Science",
          "location": "Building A"
        },
        "subjects": [
          {
            "subjectName": "DSA",
            "marksObtained": 85
          },
          {
            "subjectName": "OOPs",
            "marksObtained": 90
          }
        ]
      }
    """.trimIndent()

    every { studentService.createStudent(any<Student>()) } returns student

    mockMvc.perform(
      post("/api/v1/student/add")
        .contentType("application/json")
        .content(studentJson)
    ).andExpect(status().isCreated)
      .andExpect(jsonPath("$").value("1"))
  }
}