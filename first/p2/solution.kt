package first.p2

import java.io.File

fun main() {
    val input = File("first/p2/input.txt").readLines().map { it.toLong() }
    val sumDepth = input.mapIndexedNotNull { index, s ->
        if (index > input.size-3) null
        else {
            val sum = input[index] + input[index + 1] + input[index + 2]
            sum
        }
    }
    var numberOfIncrease = 0
    sumDepth.forEachIndexed { index, l ->
        if (index == 0) return@forEachIndexed
        if (l > sumDepth[index-1]) {
            numberOfIncrease++
        }
    }
    println(numberOfIncrease)
}
