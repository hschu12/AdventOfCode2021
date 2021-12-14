package third.p1

import java.io.File

data class Bit(
    val leastCommon: Char,
    val mostCommon: Char
)

fun findLeastAndMostCommon(input: List<String>):List<Bit> {
    return input.map {
        var ones = 0
        var zeros = 0
        it.forEach { c ->
            when {
                c == '1' -> {
                    ones++
                }
                c == '0' -> {
                    zeros++
                }
            }
        }
        if (ones > zeros) {
            Bit('0', '1')
        }
        else {
            Bit('1', '0')
        }
    }
}

fun main() {
    var gamma = ""
    var epsilon = ""
    val input = File("third/p1/input.txt").readLines()

    val order = mutableListOf("","","","","","","","","","","","")

    input.forEach { line ->
        line.forEachIndexed { index, c ->
            order[index] = order[index] + c
        }
    }

    val bits = findLeastAndMostCommon(order)

    bits.forEach {
        gamma += it.mostCommon
        epsilon += it.leastCommon
    }

    val gam = gamma.toInt(2)
    val eps = epsilon.toInt(2)
    println("Result:")
    println("Gamma Binary: $gamma")
    println("Epsilon Binary: $epsilon")
    println("Gamma: $gam")
    println("Epsilon: $eps")
    println("Gamma x Epsilon: ${gam * eps}")

}

