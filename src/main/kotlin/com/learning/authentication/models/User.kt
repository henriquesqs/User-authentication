package com.learning.authentication.models

import com.fasterxml.jackson.annotation.JsonCreator
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Required
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="User")
data class User(
    @Id
    @Field("_id")
    val id: ObjectId,
    var username: String,
    var password: String
)

// @JsonCreator tells Jackson to parse any input coming through this class as JSON.
data class NewUser @JsonCreator constructor(
    val username: String,
    val password: String
)
