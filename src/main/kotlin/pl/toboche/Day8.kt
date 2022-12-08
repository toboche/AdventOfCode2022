package pl.toboche

import kotlin.math.max

class Day8 {

    data class Point(val x: Int, val y: Int)

    fun task1(input: List<String>, findMin: Boolean = false): Int {
        val visible = Array(input.size) { BooleanArray(input[0].length) }

        traverseHorizontally(
            input,
            visible,
            0 until input.size,
            0 until input[0].length
        ) { curr, max, i, j -> analyse(curr, max, visible, i, j) }
        traverseHorizontally(
            input,
            visible,
            input.size - 1 downTo 0,
            input[0].length - 1 downTo 1
        ) { curr, max, i, j -> analyse(curr, max, visible, i, j) }
        traverseVertically(input, visible, 0 until input[0].length, 0 until input.size){ curr, max, i, j -> analyse(curr, max, visible, i, j) }
        traverseVertically(input, visible, input[0].length - 1 downTo 0, input.size - 1 downTo 0){ curr, max, i, j -> analyse(curr, max, visible, i, j) }
        return visible.sumOf { it.count { it } }
    }

    private fun traverseHorizontally(
        input: List<String>,
        visible: Array<BooleanArray>,
        outerLoopRange: IntProgression,
        innerLoopRange: IntProgression,
        onItemAction: (Int, Int, Int, Int) -> Unit
    ) {
        for (i in outerLoopRange) {
            val line = input[i]
            var max = -1
            for (j in innerLoopRange) {
                val curr = line[j].digitToInt()
                onItemAction(curr, max, i, j)
                max = max(max, curr)
            }
        }
    }

    private fun analyse(
        curr: Int,
        max: Int,
        visible: Array<BooleanArray>,
        i: Int,
        j: Int
    ) {
        if (curr > max) {
            visible[i][j] = true
        }
    }

    private fun traverseVertically(
        input: List<String>,
        visible: Array<BooleanArray>,
        outerLoopRange: IntProgression,
        innerLoopRange: IntProgression,
        onItemAction: (Int, Int, Int, Int) -> Unit
    ) {
        for (j in outerLoopRange) {
            var max = -1
            for (i in innerLoopRange) {
                val curr = input[i][j].digitToInt()
                onItemAction(curr, max, i, j)
                max = max(max, curr)
            }
        }
    }
}