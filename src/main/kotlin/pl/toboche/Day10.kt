package pl.toboche

class Day10 {

    sealed interface Instruction
    object Noop : Instruction
    data class Addx(val value: Int) : Instruction

    fun task1(input: List<String>): Pair<Int, String> {
        val screen = mutableListOf<Char>()
        var currentPixelPosition = 0
        return (input.flatMap {
            if (it == "noop") {
                listOf<Instruction>(Noop)
            } else {
                val value = it.split(" ")[1].toInt()
                listOf(Noop, Addx(value))
            }
        })
            .runningFold(1) { acc, instruction ->
                val currentXValue = when (instruction) {
                    Noop -> acc
                    is Addx -> acc + instruction.value
                }

                if (acc == currentPixelPosition % 40 ||
                    acc == (currentPixelPosition % 40) - 1 ||
                    acc == (currentPixelPosition % 40) + 1
                ) {
                    screen.add('#')
                } else {
                    screen.add('.')
                }
                if (((currentPixelPosition + 1) % 40 == 0 && currentPixelPosition != 0)) {
                    screen.add('\n')
                }
                currentPixelPosition += 1
                currentXValue
            }
            .withIndex()
            .filter { (index, _) ->
                (index + 21) % 40 == 0
            }
            .sumOf { (index, i) ->
                (index + 1) * i
            } to screen.joinToString("").dropLast(1)
    }
}