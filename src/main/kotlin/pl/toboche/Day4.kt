package pl.toboche

class Day4 {
    fun task1(input: List<String>): Int {
        return input.count {
            val (first, second) = it.split(",")
                .map {
                    val (li, ri) = it.split("-").map { it.toInt() }
                    IntRange(li, ri)
                }
            val intersectionSize = first.intersect(second).size
            intersectionSize == first.count() || intersectionSize == second.count()
        }
    }

    fun task2(input: List<String>): Int {
        return -1
    }
}