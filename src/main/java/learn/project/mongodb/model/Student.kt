package learn.project.mongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "student")
data class Student(
  @Id
  private val id: String,

  @Field("name") //can be removed as the field name is as the property name
  private val name: String,

  @Field("mail")
  private val email: String,

  private val department: Department,

  private val subjects: List<Subject>,
)