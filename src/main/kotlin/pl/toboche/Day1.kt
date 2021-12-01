package pl.toboche

class Day1 {
    fun task1(input: List<String>): Int {
        return input.map { it.toInt() }
            .windowed(2)
            .count { (left, right) -> right > left }
    }

    fun task2(input: List<String>): Int {
        return input.map { it.toInt() }
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count { (left, right) -> right > left }
    }
}