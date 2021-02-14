package com.learning.authentication

import com.mongodb.MongoClient
import com.mongodb.MongoException

object ConnectionToDB {
    @JvmStatic
    fun main(args: Array<String>){
        var mongoClient: MongoClient? = null
        try {
            mongoClient = MongoClient("localhost", 27017)
            println("Kotlin connected to MongoDB!")
        } catch (e: MongoException) {
            e.printStackTrace()
        } finally {
            mongoClient!!.close()
        }
    }
}