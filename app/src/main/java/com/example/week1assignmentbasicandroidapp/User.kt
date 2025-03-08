package com.example.week1assignmentbasicandroidapp

// Question 2-1 Implement a Kotlin class named User with properties like name, age, and email.
class User: Person{ //Extends Person class
    var name: String
    var age: Int
    var email: String
    constructor(name:String, age:Int, email:String){
        this.name = name
        this.age = age
        this.email = email
        var userDetails: UserDetails = UserDetails(name, age, email)
    }
    override fun toString(): String {
        println("User Name: $name\nUser Age: $age\nUser Email: $email\n")
        return super.toString()
    }

}