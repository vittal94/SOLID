package org.example.ISP

import java.util.Timer

//TimerDoor example without ISP

open class TimerClient {
    open fun timeOut(seconds: Int) {
        println("Timeout in $seconds seconds.")
    }
}
class TimedDoor : TimerClient() {
    fun lock() {
        println("Locking the door.")
    }
    fun unlock() {
        println("Unlocking the door.")
    }
    fun isOpen(): Boolean = false

    override fun timeOut(seconds: Int) {
        println("Timeout of door in $seconds seconds.")
    }
}

//Using ISP with delegating

interface Door {
    fun lock()
    fun unlock()
    fun isOpen():Boolean
}
interface TimerClient1 {
    fun timeOut(seconds: Int)
}

class TimedDoor1 : Door {
    private val timer = DoorTimerAdapter(this)
    override fun lock() {
        TODO("Not yet implemented")
    }

    override fun unlock() {
        TODO("Not yet implemented")
    }

    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }
     fun doorTimeout(seconds: Int) {
        timer.timeOut(seconds)
    }
    private class DoorTimerAdapter(val timerDoor: TimedDoor1) : TimerClient1 {
        override fun timeOut(seconds: Int) {
            timerDoor.doorTimeout(seconds)
        }
    }
}

//using ISP with multiple inheritance

abstract class Door1 {
   open fun lock(){
        println("The door locking.")
    }
    open fun unlock() {
        println("The door unlocking.")
    }
    open fun isLocked(): Boolean = true
}

interface TimerClient2 {
     fun timeOut(seconds: Int) {
        println("Timer is out in $seconds seconds.")
    }
}
class TimedDoor2 : Door1(), TimerClient2 {
    fun doorTimeout(seconds: Int) {
        this.timeOut(seconds)
    }
}
