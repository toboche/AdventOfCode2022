package pl.toboche

class Day3 {
    fun task1(input: List<String>): Int {
        return input.sumOf { line ->
            val length = line.length
            val inLeft = mutableSetOf<Char>()
            line.take(length / 2).forEach { char ->
                inLeft.add(char)
            }
            val duplicate = line.drop(length / 2).first { inLeft.contains(it) }
            if (duplicate.isUpperCase()) {
                duplicate.code - 'A'.code + 27
            } else {
            duplicate.code - 'a'.code + 1
            }
        }
    }

    fun task2(input: List<String>): Int {
        return -1
    }
}