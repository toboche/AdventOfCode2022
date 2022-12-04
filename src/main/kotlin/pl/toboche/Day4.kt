package pl.toboche

class Day4 {
    fun task1(input: List<String>): Int {
        return countWhenOverlapCondition(input) { intersectionSize, first, second -> intersectionSize == first.count() || intersectionSize == second.count() }
    }

    private fun countWhenOverlapCondition(input: List<String>, condition: (Int, IntRange, IntRange) -> Boolean) =
        input.count {
            val (first, second) = it.split(",")
                .map {
                    val (li, ri) = it.split("-").map { it.toInt() }
                    IntRange(li, ri)
                }
            val intersectionSize = first.intersect(second).size
            condition(intersectionSize, first, second)
        }

    fun task2(input: List<String>): Int {
        return countWhenOverlapCondition(input) { intersectionSize, first, second -> intersectionSize >= 1 }
    }
}