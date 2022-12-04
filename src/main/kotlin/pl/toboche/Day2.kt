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

    enum class State(val char: Char) {
        LOOSE('X'),
        DRAW('Y'),
        WIN('Z')
    }

    fun task1(input: List<String>): Int {
        return input.sumOf { line ->
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
        }
    }

    fun task2(input: List<String>): Int {
        return input.sumOf { line ->
            val op = Op.values().first { it.char == line[0] }
            val state = State.values().first { it.char == line[2] }
            val me = if (state == State.WIN) {
                when (op) {
                    Op.SCISSORS -> Me.ROCK
                    Op.PAPER -> Me.SCISSORS
                    Op.ROCK -> Me.PAPER
                }
            } else if (state == State.LOOSE) {
                when (op) {
                    Op.SCISSORS -> Me.PAPER
                    Op.PAPER -> Me.ROCK
                    Op.ROCK -> Me.SCISSORS
                }
            } else {
                when (op) {
                    Op.SCISSORS -> Me.SCISSORS
                    Op.PAPER -> Me.PAPER
                    Op.ROCK -> Me.ROCK
                }
            }
            val forFigure = when (me) {
                Me.ROCK -> 1
                Me.PAPER -> 2
                else -> 3
            }
            val forState = when (state) {
                State.WIN -> 6
                State.DRAW -> 3
                else -> 0
            }
            forState + forFigure
        }
    }
}