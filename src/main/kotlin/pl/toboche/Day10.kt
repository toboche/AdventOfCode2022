package pl.toboche

class Day10 {

    val points = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137,
    )

    val counterparts = mapOf(
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

}