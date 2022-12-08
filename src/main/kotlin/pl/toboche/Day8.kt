package pl.toboche

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
}