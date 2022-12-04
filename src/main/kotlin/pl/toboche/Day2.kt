package pl.toboche

class Day2 {

    enum class Op(val char: Char) {
        ROCK('A'),
        PAPER('B'),
        SCISSORS('C')
    }

    enum class Me(val char: Char) {
        ROCK('X'),
        PAPER('Y'),
        SCISSORS('Z')
    }


    fun task1(input: List<String>): Int {
        return input.map { line ->
            val op = Op.values().first { it.char == line[0] }
            val me = Me.values().first { it.char == line[2] }
            val win = me == Me.ROCK && op == Op.SCISSORS ||
                    me == Me.SCISSORS && op == Op.PAPER ||
                    me == Me.PAPER && op == Op.ROCK
            val draw = me == Me.ROCK && op == Op.ROCK ||
                    me == Me.SCISSORS && op == Op.SCISSORS ||
                    me == Me.PAPER && op == Op.PAPER
            val forFigure = when (me) {
                Me.ROCK -> 1
                Me.PAPER -> 2
                else -> 3
            }
            val forState = if (win) {
                6
            } else if (draw) {
                3
            } else {
                0
            }
            forState + forFigure
        }.sum()
    }

    fun task2(input: List<String>): Int {
        return -1
    }
}