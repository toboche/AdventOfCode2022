package pl.toboche

class Day2 {
    data class Position(
        val horizontal: Int,
        val depth: Int,
    )

    data class Aim(
        val aim: Int,
        val position: Position,
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

    fun task2(input: List<String>): Int {
        return input.fold(Aim(0, Position(0, 0))) { aim, it ->
            val (command, valueString) = it.split(" ")
            val value = valueString.toInt()
            when (command) {
                "forward" -> aim.copy(position = aim.position.copy(horizontal = aim.position.horizontal + value,
                    depth = aim.position.depth + aim.aim * value))
                "down" -> aim.copy(aim = aim.aim + value)
                "up" -> aim.copy(aim = aim.aim - value)
                else -> throw Exception(command)
            }
        }.let {
            it.position.horizontal * it.position.depth
        }
    }
}