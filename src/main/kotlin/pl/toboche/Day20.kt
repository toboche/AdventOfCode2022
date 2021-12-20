package pl.toboche

class Day20 {
    private val adjacentVectors = (-1..1).flatMap { x -> (-1..1).map { x to it } }

    fun task1(input: List<String>, iterations: Int): Int {
        val code = input[0]

        val rest = input.drop(2)
        var new: List<String> = rest
        var default = '.'
        repeat(iterations) {
            new = (-1..new.size).map { y ->
                (-1..new.first().length).map { x ->
                    val joinToString = adjacentVectors
                        .map { (dy, dx) -> x + dx to y + dy }
                        .map { (x, y) ->
                            if (!(0 until new.first().length).contains(x) || !(new.indices).contains(y)) {
                                default
                            } else {
                                new[y][x]
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
            default = if (default == '.') code.first() else code.last()
        }
        return new.sumOf { it.count { it == '#' } }
    }
}