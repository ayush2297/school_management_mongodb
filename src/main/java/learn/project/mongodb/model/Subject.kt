package learn.project.mongodb.model

import org.springframework.data.mongodb.core.mapping.Field

data class Subject(
  @Field("subject_name")
  val subjectName: String,

  @Field("marks_obtained")
  val marksObtained: Int
)