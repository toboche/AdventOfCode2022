package pl.toboche

import kotlin.math.abs
import kotlin.math.max

class Day8 {

    data class Point(val x: Int, val y: Int)

    fun task1(input: List<String>, findMin: Boolean = false): Int {
        val visible = Array(input.size) { BooleanArray(input[0].length) }

        traverseHorizontally(input, visible, 0 until input.size, 0 until input[0].length)
        traverseHorizontally(input, visible, input.size - 1 downTo 0, input[0].length - 1 downTo 1)
        traverseVertically(input, visible, 0 until input[0].length, 0 until input.size)
        traverseVertically(input, visible, input[0].length - 1 downTo 0, input.size - 1 downTo 0)
        return visible.sumOf { it.count { it } }
    }

    private fun traverseHorizontally(
        input: List<String>,
        visible: Array<BooleanArray>,
        outerLoopRange: IntProgression,
        innerLoopRange: IntProgression
    ) {
        for (i in outerLoopRange) {
            val line = input[i]
            var max = -1
            for (j in innerLoopRange) {
                val curr = line[j].digitToInt()
                if (curr > max) {
                    visible[i][j] = true
                }
                max = max(max, curr)
            }
        }
    }

    private fun traverseVertically(
        input: List<String>,
        visible: Array<BooleanArray>,
        outerLoopRange: IntProgression,
        innerLoopRange: IntProgression
    ) {
        for (j in outerLoopRange) {
            var max = -1
            for (i in innerLoopRange) {
                val curr = input[i][j].digitToInt()
                if (curr > max) {
                    visible[i][j] = true
                }
                max = max(max, curr)
            }
        }
    }

    fun task2(input: List<String>, findMin: Boolean = false): Int {
        val (height, width) = input.size to input[0].length
        return (1 until height - 1).fold(0) { maxScenicScore, y ->
            (1 until width - 1).fold(maxScenicScore) { maxScenicScore, x ->
                listOf(
                    (y - 1 downTo 0).map { input[it][x] }, // north
                    (y + 1 until height).map { input[it][x] }, // south
                    (x + 1 until width).map { input[y][it] }, // east
                    (x - 1 downTo 0).map { input[y][it] } // west
                )
                    .map { direction ->
                        direction.takeWhile { it < input[y][x] }
                            .run { if (this.size == direction.size) this.count() else this.count() + 1 }
                    }
                    .reduce(Int::times)
                    .run { max(this, maxScenicScore) }
            }
        }
    }
}