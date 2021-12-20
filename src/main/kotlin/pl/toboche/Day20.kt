package pl.toboche

class Day20 {
    private val adjacentVectors = (-1..1).flatMap { x -> (-1..1).map { x to it } }

    fun task1(input: List<String>): Int {
        val iterations = 2
        val code = input[0]
        val xLen = input[2].length + (2 * iterations)
        val yLen = input.size - 2 + (2 * iterations)

        val rest =
            (0 until iterations).map { (0..xLen).map { '.' }.joinToString("") } +
                    input.drop(2)
                        .map { "..$it.." } +
                    (0 until iterations).map { (0..xLen).map { '.' }.joinToString("") }
        var new: List<String> = rest
        repeat(iterations) { iter ->
            val old = new.map { it.map { it } }
            new = new.mapIndexed { y, line ->
                line.mapIndexed { x, _ ->
                    val joinToString = adjacentVectors
                        .map { (dy, dx) -> x + dx to y + dy }
                        .map { (x, y) ->
                            if (x < 0 || y < 0 || y >= yLen || x >= xLen) {
                                '.'
                            } else {
                                old[y][x]
                            }
                        }
                        .map {
                            when (it) {
                                '.' -> '0'
                                '#' -> '1'
                                else -> throw  Exception()
                            }
                        }.joinToString("")
                    val int = joinToString
                        .toInt(2)
                    code[int]
                }.joinToString("")
            }
        }
        return new.sumOf { it.count { it == '#' } }
    }
}