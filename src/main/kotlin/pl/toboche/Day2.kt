package pl.toboche

class Day2 {
    data class Position(
        val horizontal: Int,
        val depth: Int,
    )

    fun task1(input: List<String>): Int {
        return input.fold(Position(0, 0)) { position, it ->
            val (command, valueString) = it.split(" ")
            val value = valueString.toInt()
            when (command) {
                "forward" -> position.copy(horizontal = position.horizontal + value)
                "down" -> position.copy(depth = position.depth + value)
                "up" -> position.copy(depth = position.depth - value)
                else -> throw Exception(command)
            }
        }.let {
            it.horizontal * it.depth
        }
    }
}