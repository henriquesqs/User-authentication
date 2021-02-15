package com.learning.authentication.controllers

import com.learning.authentication.models.User
import com.learning.authentication.models.UserRequest
import com.learning.authentication.repositories.UserRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userRepo: UserRepository) {

    // Retrieves a List with all users on database
    @GetMapping("/")
    fun getAllUsers(): ResponseEntity<List<User>> = ResponseEntity.ok(userRepo.findAll())

    // Prints a simple message on /hello endpoint
    @RequestMapping("/hello")
    fun hello() = "Hello, signup at /signup"

    // This method checks for a document on dabase given its id
    @GetMapping("/{id}")
    fun getOneUser(@PathVariable("id") id: String) = ResponseEntity.ok(userRepo.findOneById(ObjectId(id)))

    // This removes a document on database given its id
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: String): ResponseEntity<Unit> {
        userRepo.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    // This endpoint checks for a document with given username
    @GetMapping("/users/{username}")
    fun findUser(@PathVariable("username") username: String) = userRepo.findUserByUsername(username)

    // Signup endpoint. Receives an username and password via request body and
    // creates a new entry (document) on database
    @PostMapping("/signup")
    fun signup(@RequestBody request: UserRequest): ResponseEntity<User> {
        val user = User(username = request.username, password = request.password)
        userRepo.save(user)
        return ResponseEntity(user, HttpStatus.CREATED)
    }

    // Login endpoint. Simply receives an username and password via request body
    // and checks for an user with that username. If found one, checks whether the
    // password is correct or not.
    @PostMapping("/login")
    fun login(@RequestBody request: UserRequest): String {
        val user = userRepo.findUserByUsername(request.username)

        if(user != null && request.password == user.password)
            return "Logged in!\n"

        return "Error while attempting to login...\n"
    }

}