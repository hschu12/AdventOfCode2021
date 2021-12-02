package second.p2

import java.io.File

fun main() {
    var horizontal = 0L
    var depth = 0L
    var aim = 0L
    val input = File("second/p2/input.txt").readLines()
    input.forEach { command ->
        val c = command.split(" ")
        when {
            c.first() == "up" -> {
                aim -= c[1].toLong()
            }
            c.first() == "down" -> {
                aim += c[1].toLong()

            }
            c.first() == "forward" -> {
                horizontal += c[1].toLong()
                depth += c[1].toLong() * aim
            }
        }       
    }
    println("Result:")
    println("depth:$depth, horizontal:$horizontal")
    println("$depth x $horizontal = ${depth*horizontal}")
}
