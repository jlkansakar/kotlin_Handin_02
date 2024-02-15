package com.example.kotlin_handin_02

fun main() {
    val emp1: Employee = Employee("John", "Doe", 6000)
    val emp2: Employee = Employee("Jane", "Doe", 7500)
    println("${emp1.firstName} makes ${emp1.salary * 12} dollars in a year")
    println("${emp2.firstName} makes ${emp2.salary * 12} dollars in a year")
    println("After a raise, ${emp1.firstName} makes ${(emp1.salary * 1.1) * 12} in a year")
    println("After a raise, ${emp2.firstName} makes ${(emp2.salary * 1.1) * 12} in a year")
}


class Employee(firstName: String, lastName: String, salary: Int) {
    val firstName: String = firstName
    val lastName: String = lastName
    private var _salary: Int = salary
    var salary: Int
        get() {
            return _salary
        }
        set(value: Int) {
            if (value >= 0) {
                _salary = value
            } else {
                _salary = 0
            }
        }
}

open class Computer(speedInGHz: Float) {
    val screenSizeInInches: Int = 0
    val prebuilt: Boolean = true
    val

}