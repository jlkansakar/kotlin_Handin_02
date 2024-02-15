package com.example.kotlin_handin_02
import kotlin.math.pow
import kotlin.math.PI
import kotlin.math.sqrt

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

    val myCircle: Circle = Circle(22.0)
    println(myCircle.calculateArea())
    println(myCircle.calculatePerimeter())

    val myRectangle: Rectangle = Rectangle(10, 15)
    println(myRectangle.calculateArea())
    println(myRectangle.calculatePerimeter())

    val myTriangle: Triangle = Triangle(10.0, 15.0)
    println(myTriangle.calculateArea())
    println(myTriangle.calculatePerimeter())
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

abstract class Shape(color: String, isTransparent: Boolean){
    open fun calculatePerimeter(): Int {
        val perimeter: Int = 0
        return perimeter
    }
    open fun calculateArea(): Int {
        val area: Int = 0
        return area
    }
}

class Circle(private val radius: Double): Shape(color = "Green", isTransparent = true){
    override fun calculatePerimeter(): Int {
        val perimeter: Int = (2 * radius * PI).toInt()
        return perimeter
    }

    override fun calculateArea(): Int {
        val area: Int = (PI * radius.pow(2)).toInt()
        return area
    }
}

class Rectangle(private val height: Int, private val length: Int): Shape(color = "Blue", isTransparent = false){
    override fun calculatePerimeter(): Int {
        val perimeter: Int = 2 * height + 2 * length
        return perimeter
    }

    override fun calculateArea(): Int {
        val area: Int = height * length
        return area
    }
}

class Triangle(private val height: Double, private val length: Double, private val hypotenuse: Int = (sqrt(height.pow(2) + length.pow(2))).toInt() ): Shape(color = "Yellow", isTransparent = true){
    override fun calculatePerimeter(): Int {
        val perimeter: Int = height.toInt() + length.toInt() + hypotenuse
        return perimeter
    }

    override fun calculateArea(): Int {
        val area: Int = (height.toInt() * length.toInt()) / 2
        return area
    }
}
