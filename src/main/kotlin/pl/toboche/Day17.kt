package pl.toboche

import kotlin.math.absoluteValue
import kotlin.math.max

class Day17 {
    fun task1(input: String): Int {
        val (xmin, xmax) = input.substringAfter("target area: x=")
            .split(", ")[0]
            .split("..")
            .map { it.toInt() }
        val xrange = xmin..xmax

        val (ymin, ymax) = input.substringAfter("y=")
            .split("..")
            .map { it.toInt() }
        val yrange = ymin..ymax


        var highest = Int.MIN_VALUE

        for (xvel in 1..xmax) {
            for (yvel in ymin..ymin.absoluteValue) {
                val current = simulate(xvel, yvel, xrange, yrange)
                if (current != Int.MIN_VALUE) {
                    highest = max(highest, current)
                }
            }
        }

        return highest
    }

    private fun simulate(
        xvel: Int,
        yvel: Int,
        xrange: IntRange,
        yrange: IntRange,
    ): Int {
        var xvel1 = xvel
        var yvel1 = yvel
        var x = 0
        var y = 0
        var highest = Int.MIN_VALUE
        var targetReached = false
        while (x <= xrange.last && y >= yrange.last) {
            x += xvel1
            if (xvel1 > 0) xvel1 -= 1 else if (xvel1 < 0) xvel1 += 1
            y += yvel1
            yvel1 -= 1
            highest = max(highest, y)
            if (xrange.contains(x) && yrange.contains(y)) {
                targetReached = true
                break
            }
        }
        return if (targetReached) highest else Int.MIN_VALUE
    }
}