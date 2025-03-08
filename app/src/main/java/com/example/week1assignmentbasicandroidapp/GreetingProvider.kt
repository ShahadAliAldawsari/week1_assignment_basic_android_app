package com.example.week1assignmentbasicandroidapp

// Question 3-1 Create an interface named GreetingProvider with a method provideGreeting().
interface GreetingProvider {
    fun provideGreeting(): String
}

// Question 3-2 Implement the interface in a class FriendlyGreeting that returns a greeting message.
class FriendlyGreeting : GreetingProvider{
    override fun provideGreeting(): String {
        return "Hi, Wellcome..."
    }
}
