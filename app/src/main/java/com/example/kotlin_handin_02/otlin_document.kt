package com.example.kotlin_handin_02

fun main() {
    val emp1: Employee = Employee("John", "Doe", 6000)
    val emp2: Employee = Employee("Jane", "Doe", 7500)
    println("${emp1.firstName} makes ${emp1.salary * 12} dollars in a year")
    println("${emp2.firstName} makes ${emp2.salary * 12} dollars in a year")
    println("After a raise, ${emp1.firstName} makes ${(emp1.salary * 1.1) * 12} in a year")
    println("After a raise, ${emp2.firstName} makes ${(emp2.salary * 1.1) * 12} in a year")

    val asusLaptop: Laptop = Laptop("Asus Chromebook")
    asusLaptop.screenSizeInInches = 14.0
    asusLaptop.ramInGB = 16
    asusLaptop.speedInGHz = 3.5
    asusLaptop.integratedGraphics = true
    asusLaptop.cleanLaptop()
    asusLaptop.boostGHz()
    println("The laptop has a ${asusLaptop.screenSizeInInches} inch screen, and has ${asusLaptop.ramInGB} GB of ram. The cpu turbos to ${asusLaptop.speedInGHz} GHz, and it has strong integrated graphics ${asusLaptop.integratedGraphics}")

    val xaomiPhone: Smartphone = Smartphone("Xaomi Poco X3")
    xaomiPhone.chargingPort = "usb-c"
    xaomiPhone.speedInGHz = 2.4
    xaomiPhone.screenSizeInInches = 8.9
    xaomiPhone.integratedGraphics = true
    xaomiPhone.crackScreen()
    xaomiPhone.boostGHz()
    println("The phone has an ${xaomiPhone.screenSizeInInches} inch screen, and has a ${xaomiPhone.chargingPort} charging point. The cpu turbos to ${xaomiPhone.speedInGHz} GHz, and it has strong integrated graphics ${xaomiPhone.integratedGraphics}")

    val nikeAirmax: Shoe = Shoe("Nike Airmax", 80, 1)
    nikeAirmax.identifyProductCategory()
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

open class Computer(model: String) {
    var screenSizeInInches: Double = 0.0
    var speedInGHz: Double = 0.0
    var integratedGraphics: Boolean = true


    fun boostGHz(){
        speedInGHz * 2
    }
    fun externalGraphicsCard(){
        integratedGraphics = false
    }
}

class Laptop(model: String): Computer(model) {
    var ramInGB: Int = 0
    fun cleanLaptop(){
        speedInGHz * 1.25
    }
}

class Smartphone(model: String): Computer(model) {
    var chargingPort: String = ""
    fun crackScreen(){
        screenSizeInInches * 0.95 // screen is obscured by crack haha
    }
}

abstract class Product(val name: String, val price: Int, val quantity: Int){
    open fun identifyProductCategory(){
        println("I am a $name")
    }
}

class Shoe(name: String, price: Int, quantity: Int): Product(name, price, quantity){
    override fun identifyProductCategory() {
        println("I am a ${this.name}")
    }
}

class Tshirt(name: String, price: Int, quantity: Int): Product(name, price, quantity){
    override fun identifyProductCategory() {
        println("I am a ${this.name}")
    }
}

class Book(name: String, price: Int, quantity: Int): Product(name, price, quantity){
    override fun identifyProductCategory() {
        println("I am a ${this.name}")
    }
}

