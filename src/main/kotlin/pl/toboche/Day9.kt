package pl.toboche

import java.lang.Exception
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

class Day9 {

    fun task1(input: List<String>): Int {
        return task1Internal(input).size
    }

    fun task1Internal(input: List<String>): MutableSet<Pair<Int, Int>> {
        var head = 0 to 0
        var tail = 0 to 0
        val visited = mutableSetOf(tail)
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

                head = head.first + vector.first to head.second + vector.second

                val xDiff = head.first - tail.first
                val yDiff = head.second - tail.second
                val toMove = abs(xDiff) + abs(yDiff)
                if (toMove > 1 && !(abs(xDiff) ==1 && abs(yDiff)==1)) {
                    //                if (yDiff == 0) {
                    //                    tail.copy(first = tail.first + xDiff)
                    //                } else if (xDiff == 0) {
                    //                    tail.copy(second = tail.second + yDiff)
                    //                }else{
                    val xMove = if (xDiff == 0) 0 else if (xDiff >= 1) 1 else -1
                    val yMove = if (yDiff == 0) 0 else if (yDiff >= 1) 1 else -1
                    tail = tail.first + xMove to tail.second + yMove
                    visited.add(tail)
                    //                }
                }
                //            val dst = sqrt(
                //                (1 shl (head.first - tail.first) + (1 shl head.second - tail.second)).toDouble()
                //            )


                //            if (head.first == tail.first || head.second == tail.second) {
                //                if()
                //            }
                //            if (dst >= 2) {
                //
                //            }
            }

        }
        return visited
    }
}