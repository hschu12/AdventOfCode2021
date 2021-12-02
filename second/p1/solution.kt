package second.p1

import java.io.File

fun main() {
    var horizontal = 0L
    var depth = 0L
    val input = File("second/p1/input.txt").readLines()
    input.forEach { command ->
        val c = command.split(" ")
        when {
            c.first() == "up" -> {
                depth -= c[1].toLong()
            }
            c.first() == "down" -> {
                depth += c[1].toLong()

            }
            c.first() == "forward" -> {
                horizontal += c[1].toLong()
            }
        }
    }
    println("Result:")
    println("depth:$depth, horizontal:$horizontal")
    println("$depth x $horizontal = ${depth*horizontal}")
}
