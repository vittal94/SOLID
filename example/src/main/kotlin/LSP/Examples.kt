package org.example.LSP

open class Rectangle(open var width: Double, open var height: Double) {
    open fun area(): Double {
        return width * height
    }

    override fun toString(): String {
        return "Rectangle(width=$width, height=$height)"
    }

}

class Square(var size: Double) : Rectangle(size,size) {
   private var widthBackingField: Double = 0.0
   private var heightBackingField: Double = 0.0

    override var height: Double
        get() = heightBackingField
        set(value) {                    //this setter resets value of width
            heightBackingField = value
            widthBackingField = value
        }

    override var width: Double
        get() = widthBackingField
        set(value) {                 //this setter resets value of height
            widthBackingField = value
            heightBackingField = value
        }

    override fun area(): Double {
        return width * height
    }

    override fun toString(): String {
        return "Square(size=$size, width=$width, height=$height)"
    }

}

//this is  work because we just rewrite the width when setting height
fun setSizeOfSquare() {
    val square: Square = Square(25.0)
    square.width = 50.0
    square.height = 45.0
    println(square)
}

//but when we use the area assertion in case of square it does not work
fun testShapeSize() {
    fun shapeSize(figure: Rectangle) {
        figure.height = 25.0
        figure.width = 45.0

        assert(figure.area() == 1125.0)

    }
    shapeSize(Rectangle(2.0,4.9))
    shapeSize(Square(23.0))
}

fun main() {
    setSizeOfSquare()
    testShapeSize()
}