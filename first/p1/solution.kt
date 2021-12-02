import java.io.File

fun main() {
    val input = File("first/p1/input.txt").readLines()
    var numberOfIncrease = 0
    input.forEachIndexed { index, s ->
        if (index == 0) return@forEachIndexed
        val depth = s.toLong()
        if (depth > input[index-1].toLong()) {
            numberOfIncrease++
        }
    }
    println(numberOfIncrease)
}
