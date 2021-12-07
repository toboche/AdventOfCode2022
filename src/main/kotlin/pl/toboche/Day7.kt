package pl.toboche

class Day7 {
    fun task1(input: String): Int {
        val positions = input.split(",")
            .map { it.toInt() }
        val sorted = positions
            .sorted()
        val median = sorted[positions.count() / 2]
        return positions.sumOf {
            if (median > it) median - it
            else it - median
        }

    }
}