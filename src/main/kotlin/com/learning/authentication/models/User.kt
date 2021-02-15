package com.learning.authentication.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class User(
    @Id
    val id: ObjectId = ObjectId.get(),
    var username: String,
    var password: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val modifiedAt: LocalDateTime = LocalDateTime.now()
)

// Request object to handle incoming requests
class UserRequest (
    var username: String,
    var password: String
)
