package com.example.week1assignmentbasicandroidapp

fun main(){
// Question 2-3 Demonstrate collections (List, Set, Map)
// by adding a list of sample users.
    var users: List<User> = listOf(
        User("Shahad", 25, "sh@gmail.com"),
        User("Raghad", 24, "r@gmail.com"),
        User("Adam", 24, "a@gmail.com"),
        User("Sarah", 13, "s@gmail.com"),
    )

// Question 2-4 Use lambdas and higher-order functions to filter
// users above 18 years. Syntax of Lambda expression:
    val getOldUsers= {users: List<User> -> users.filter { it.age > 18}}
    getOldUsers(users).toString()

}


