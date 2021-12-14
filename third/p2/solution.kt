package third.p2

import java.io.File

data class Bit(
    val leastCommon: Char,
    val mostCommon: Char
)
//TODO() RETURNS WRONG ANSWER
fun returnSingle(binaryNumbers: List<String>, rotatedList: List<String>, index: Int, keepMost: Boolean): String{
    val bits = rotatedList[index]
    val significant = findLeastAndMostCommon(bits).let { if (keepMost) it.mostCommon else it.leastCommon }
    println(significant)
    val filteredBinaries = binaryNumbers.mapNotNull {
        if (it[index] == significant) {
            println(it)
            it
        } else null
    }
    return if (filteredBinaries.size == 1) {
        filteredBinaries.first()
    }
    else {
        returnSingle(filteredBinaries, rotatedList, index + 1, keepMost)
    }
}

fun findLeastAndMostCommon(s: String):Bit {
    var ones = 0
    var zeros = 0
    s.forEach { c ->
        when (c) {
            '1' -> {
                ones++
            }
            '0' -> {
                zeros++
            }
        }
    }
    println(ones)
    println(zeros)
    return when {
        ones > zeros -> {
            println("Most 1s")
            Bit('0', '1')
        }
        ones == zeros -> {
            println("EQUAL")
            Bit('0', '1')
        }
        else -> {
            println("Most 0s")
            Bit('1', '0')
        }
    }
}

fun main() {
    val input = File("third/p2/input.txt").readLines()

    val order = mutableListOf("","","","","","","","","","","","")

    val binaryNumbers = input.map { line ->
        line.forEachIndexed { index, c ->
            order[index] = order[index] + c
        }
        line
    }

    val oxy = returnSingle(binaryNumbers, order, 0, true)
    val co = returnSingle(binaryNumbers, order, 0, false)

    val o = oxy.toInt(2)
    val c = co.toInt(2)
    println("Result:")
    println("Oxygen Binary: $oxy")
    println("CO2 Binary: $co")
    println("Oxygen: $o")
    println("CO2: $c")
    println("Oxygen x CO2: ${o * c}")

}

