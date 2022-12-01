package pl.toboche

class Day1 {
    fun task1(input: List<String>): Int {
        var sum = 0
        var max = 0
        input.forEach {
            if (it.isEmpty()) {
                max = Math.max(max, sum)
                sum = 0
            } else {
                sum += it.toInt()
            }
        }
        return max
    }

    fun task2(input: List<String>): Int {
        return input.map { it.toInt() }
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count { (left, right) -> right > left }
    }
}