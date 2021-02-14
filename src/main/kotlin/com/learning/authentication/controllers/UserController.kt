package com.learning.authentication.controllers

import com.learning.authentication.models.NewUser
import com.learning.authentication.models.User
import com.learning.authentication.repositories.UserRepository
import org.bson.types.ObjectId
import org.springframework.data.domain.Example
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userRepo: UserRepository) {


    // Retrieves a List with all users
    @GetMapping("/")
    fun getAllUsers(): List<User> {
        val users = userRepo.findAll()
        return users
    }

    // Prints a simple message on /hello endpoint
    @RequestMapping("/hello")
    fun hello() = "Hello, signup at /signup"

    // Saves a new User on database. The 'username' and 'password' fields are given via request body
    @RequestMapping("/signup", method = [RequestMethod.POST])
    fun signup(@RequestBody newUser: NewUser): User{
        val user = User(ObjectId(), newUser.username, newUser.password)
        userRepo.save(user)
        return user
    }

    // Retrieves one user by its username
    @GetMapping("/{username}")
    fun getOneUserByUsername(@PathVariable("username") username: String): ResponseEntity<User> {
    //        val user = userRepo.findOne()
    //        return ResponseEntity.ok(user)
        TODO("Must first understand findOne method")
    }

    //    @RequestMapping("/login")
    //    fun login(@RequestBody userdata: User): Any {
    //        val user = userRepo.findOneByUsername(userdata.username)
    //        if(user != null && userdata.password == user.password){
    //            return ResponseEntity.ok(user)
    //        }
    //        return ResponseEntity.badRequest()
    //    }
}