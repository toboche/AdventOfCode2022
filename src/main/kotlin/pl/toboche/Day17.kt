package pl.toboche

import kotlin.math.absoluteValue
import kotlin.math.max

class Day17 {
    fun task1(input: String): Int {
        return solve(input).maxByOrNull { it.third }!!.third
    }

    fun solve(input: String): List<Triple<Int, Int, Int>> {
        val (xmin, xmax) = input.substringAfter("target area: x=")
            .split(", ")[0]
            .split("..")
            .map { it.toInt() }
        val xrange = xmin..xmax

        val (ymin, ymax) = input.substringAfter("y=")
            .split("..")
            .map { it.toInt() }
        val yrange = ymin..ymax


        val solutions = mutableListOf<Triple<Int, Int, Int>>()

        for (xvel in 1..xmax) {
            for (yvel in ymin..ymin.absoluteValue) {
                val current = simulate(xvel, yvel, xrange, yrange)
                if (current != null) {
                    solutions.add(Triple(xvel, yvel, current))
                }
            }
        }

        return solutions
    }

    private fun simulate(
        xvel: Int,
        yvel: Int,
        xrange: IntRange,
        yrange: IntRange,
    ): Int? {
        var xvel1 = xvel
        var yvel1 = yvel
        var x = 0
        var y = 0
        var highest = Int.MIN_VALUE
        while (x <= xrange.last && y >= yrange.first) {
            x += xvel1
            y += yvel1--
            if (xvel1 > 0) xvel1 -= 1 else xvel1 = 0
            highest = max(highest, y)
            if (xrange.contains(x) && yrange.contains(y)) {
                return highest
            }
        }
        return null
    }
}