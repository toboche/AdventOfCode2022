package pl.toboche

import java.lang.Exception
import kotlin.math.abs

class Day9 {

    fun task1(input: List<String>, i: Int): Int {
        return task1Internal(input, i).size
    }

    fun task1Internal(input: List<String>, lenght: Int = 1): MutableSet<Pair<Int, Int>> {
        val visited = mutableSetOf(0 to 0)
        val rope = (0..lenght).map { 0 to 0 }.toMutableList()
        input.forEach {
            val (directionS, stepsS) = it.split(" ")
            val direction = directionS.first()
            val steps = stepsS.toInt()
            repeat(steps) {
                val vector = when (direction) {
                    'U' -> 0 to 1
                    'D' -> 0 to -1
                    'L' -> -1 to 0
                    'R' -> 1 to 0
                    else -> throw Exception()
                }
                rope[0] = rope[0].first + vector.first to rope[0].second + vector.second

                (0 until lenght)
                    .map { headIndex ->
                        val head = rope[headIndex]
                        val tailIndex = headIndex + 1
                        val tail = rope[tailIndex]
                        val xDiff = head.first - tail.first
                        val yDiff = head.second - tail.second
                        val toMove = abs(xDiff) + abs(yDiff)
                        if (toMove > 1 && !(abs(xDiff) == 1 && abs(yDiff) == 1)) {
                            val xMove = if (xDiff == 0) 0 else if (xDiff >= 1) 1 else -1
                            val yMove = if (yDiff == 0) 0 else if (yDiff >= 1) 1 else -1
                            rope[tailIndex] = tail.first + xMove to tail.second + yMove
                        }
                        visited.add(rope[tailIndex])
                    }
            }

        }
        return visited
    }
}