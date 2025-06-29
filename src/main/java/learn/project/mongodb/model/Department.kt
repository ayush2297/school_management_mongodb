package learn.project.mongodb.model

import org.springframework.data.mongodb.core.mapping.Field

data class Department(
  @Field("department_name")
  val departmentName: String,

  val location: String
)