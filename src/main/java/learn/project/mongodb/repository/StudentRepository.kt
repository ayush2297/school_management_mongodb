package learn.project.mongodb.repository

import learn.project.mongodb.model.Student
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: MongoRepository<Student, String>