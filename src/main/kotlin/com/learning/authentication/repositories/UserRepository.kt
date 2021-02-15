package com.learning.authentication.repositories

import com.learning.authentication.models.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserRepository : MongoRepository<User, String> {
    fun findOneById(id: ObjectId): User

    @Query("{ 'username' : ?0 }")
    fun findUserByUsername(username: String): User?
}