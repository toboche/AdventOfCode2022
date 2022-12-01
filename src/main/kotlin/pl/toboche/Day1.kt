package pl.toboche

class Day1 {
    fun task1(input: List<String>): Int {
        var sum = 0
        var max = 0
        input.forEach {
            if (it.isEmpty()) {
                max = max.coerceAtLeast(sum)
                sum = 0
            } else {
                sum += it.toInt()
            }
        }
        return max
    }

    fun task2(input: List<String>): Int {
        val sums = mutableListOf<Int>()
        var sum = 0
        input.forEach {
            if (it.isEmpty()) {
                sums.add(sum)
                sum = 0
            } else {
                sum += it.toInt()
            }
        }
        sums.add(sum)
        return sums.sortedDescending().take(3).sum()
    }
}