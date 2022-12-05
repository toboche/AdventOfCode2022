package pl.toboche

class Day5 {

    fun task1(input: List<String>): String {
        val (numbersRowIndex, numbersRowContent) = input.withIndex().first { it.value.startsWith(" 1") }
        val numbers = numbersRowContent.split(" ").filter { it.isNotBlank() && it.isNotEmpty() }
        val stacksCount = numbers.count()
        val stacks = mutableMapOf<Int, MutableList<Char>>()
        for (i in numbersRowIndex - 1 downTo 0) {
            val line = input[i].windowed(4, 4, true)
            for (j in 1..stacksCount) {
                val item = line[j - 1][1]
                if (item == ' ') continue
                stacks.compute(j) { j, stack ->
                    (stack ?: mutableListOf()).apply {
                        add(item)
                    }
                }

            }
        }

        input.drop(numbersRowIndex + 2).forEach { line ->
            val count = line.substringAfter("move ").takeWhile { !it.isWhitespace() }.toInt()
            val fromIndex = line.substringAfter("from ").takeWhile { !it.isWhitespace() }.toInt()
            val toIndex = line.substringAfter("to ").toInt()
            repeat(count) {
                stacks[toIndex]!!.add(stacks[fromIndex]!!.removeLast())
            }
        }
        return stacks.values.map { it.last() }.joinToString("")
    }

    fun task2(input: List<String>): String {
        return ""
    }
}