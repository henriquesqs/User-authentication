package com.learning.authentication.repositories

import com.learning.authentication.models.User
import org.bson.types.ObjectId
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, ObjectId> {
    fun findOneById(id: ObjectId): User
    fun findOneByUsername(username: String): User {
        TODO("Must first understand findOne()")
    }
}