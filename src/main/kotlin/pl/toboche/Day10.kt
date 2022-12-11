package pl.toboche

class Day10 {

    sealed interface Instruction
    object Noop : Instruction
    data class Addx(val value: Int) : Instruction

    fun task1(input: List<String>): Int {
        return (input.flatMap {
            if (it == "noop") {
                listOf<Instruction>(Noop)
            } else {
                val value = it.split(" ")[1].toInt()
                listOf(Noop, Addx(value))
            }
        })
            .runningFold(1) { acc, instruction ->
                when (instruction) {
                    Noop -> acc
                    is Addx -> acc + instruction.value
                }
            }
            .withIndex()
            .filter { (index, _) ->
                (index + 21) % 40 == 0
            }
            .sumOf { (index, i) ->
                (index + 1) * i
            }
    }
}