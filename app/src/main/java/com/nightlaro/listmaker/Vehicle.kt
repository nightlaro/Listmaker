package com.nightlaro.listmaker

// Test stuff to talk about inheritance
abstract class Vehicle {

    abstract fun moveForward()
}

class Car(val numberOfWheels: Int) : Vehicle() {
    val hasPowerSteering: Boolean = true

    fun toggleHeadlights() {

    }

    override fun moveForward() {

    }
}

class Boat(val isMotorized: Boolean) : Vehicle() {
    override fun moveForward() {
        TODO("Not yet implemented")
    }

}

val car: Car = Car(4)

val vehicle: Vehicle = car

fun someTestCode() {
    car.hasPowerSteering
    car.moveForward()
    car.numberOfWheels

    vehicle.moveForward()
    (vehicle as? Car)?.let {
        it.numberOfWheels
    }
}