package pl.toboche

class Day10 {

    private val points = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137,
    )

    private val counterparts = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{',
        '>' to '<'
    )

    fun task1(input: List<String>): Int {
        return input.map {
            val stack = mutableListOf<Char>()
            for (char in it) {
                when (char) {
                    '(', '[', '<', '{' -> stack.add(char)
                    else -> {
                        val last = stack.removeLast()
                        if (last != counterparts[char]!!) {
                            return@map points[char]!!
                        }
                    }
                }
            }
            0
        }.sum()
    }

    private val autocompletePoints = mapOf(
        '(' to 1,
        '[' to 2,
        '{' to 3,
        '<' to 4,
    )

    fun task2(input: List<String>): Long {
        return input.map {
            val stack = mutableListOf<Char>()
            for (char in it) {
                when (char) {
                    '(', '[', '<', '{' -> stack.add(char)
                    else -> {
                        val last = stack.removeLast()
                        if (last != counterparts[char]!!) {
                            return@map false to stack
                        }
                    }
                }
            }
            (true to stack)
        }.filter { (ok, _) ->
            ok
        }.map { (_, stack) ->
            stack.foldRight(0L) { char, acc ->
                acc * 5 + autocompletePoints[char]!!
            }
        }.sorted()
            .let {
                it[it.size / 2]
            }
    }
}