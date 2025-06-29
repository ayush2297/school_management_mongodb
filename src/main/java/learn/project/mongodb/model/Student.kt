package learn.project.mongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "student")
data class Student(
  @Id val id: String,

  @Field("name") //can be removed as the field name is as the property name
  val name: String,

  @Field("mail")
  val email: String,

  val department: Department,

  val subjects: List<Subject>,
)