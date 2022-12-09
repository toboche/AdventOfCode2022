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


    fun task2(input: List<String>, findMin: Boolean = false): Int {
        val visible = Array(input.size) { IntArray(input[0].length) { _ -> 1 } }

        for (i in input.indices) {
            val line = input[i]
            for (j in line.indices) {
                val curr = line[j]
                if (j == 0 || i == 0 || i == line.count() - 1 || j == input.count() - 1) {
                    visible[i][j] = 0
                    continue
                }
                var max = 1
                for (k in i - 1 downTo 0) {
                    if (input[k][j] >= curr) {
                        max = max * (i - k)
                        break
                    }
                }
                for (k in i +1 until input.count()) {
                    if (input[k][j] >= curr) {
                        max = max * (k-i)
                        break
                    }
                }
                for (k in j - 1 downTo 0) {
                    if (input[i][k] >= curr) {
                        max = max * (j - k)
                        break
                    }
                }
                for (k in j +1 until line.count()) {
                    if (input[i][k] >= curr) {
                        max = max * (k - j)
                        break
                    }
                }
                visible[i][j] = max
            }
        }
        return visible.maxOf { it.maxOrNull()!! }
    }

//    fun task2(input: List<String>, findMin: Boolean = false): Int {
//        val visible = Array(input.size) { IntArray(input[0].length) { _ -> 1 } }
//
//        traverseVisibilityHorizontally(input, visible, 0 until input.size, 0 until input[0].length)
////        traverseVisibilityHorizontally(input, visible, input.size - 1 downTo 0, input[0].length - 1 downTo 1)
//        traverseVisibilityVertically(input, visible, 0 until input[0].length, 0 until input.size)
////        traverseVisibilityVertically(input, visible, input[0].length - 1 downTo 0, input.size - 1 downTo 0)
//        return visible.maxOf { it.maxOrNull()!! }
//    }

    fun traverseVisibilityHorizontally(
        input: List<String>,
        visible: Array<IntArray>,
        outerLoopRange: IntProgression,
        innerLoopRange: IntProgression
    ) {
        for (i in outerLoopRange) {
            val line = input[i]
            val lastVisitedHeightIndices = IntArray(10) { -1 }
            var max = -1
            for (j in innerLoopRange) {
                val curr = line[j].digitToInt()
                val currVisibility = (curr..9).map { lastVisitedHeightIndices[it] }
                    .filter { it != -1 }
                    .maxOrNull()
                    ?.let { j - it } ?: j
                visible[i][j] = visible[i][j] * currVisibility

                max = max(max, curr)
                lastVisitedHeightIndices[curr] = j
            }
        }
    }

    fun traverseVisibilityVertically(
        input: List<String>,
        visible: Array<IntArray>,
        outerLoopRange: IntProgression,
        innerLoopRange: IntProgression
    ) {
        for (j in outerLoopRange) {
            val lastVisitedHeightIndices = IntArray(10) { -1 }
            var max = -1
            for (i in innerLoopRange) {
                val curr = input[i][j].digitToInt()
                val currVisibility = (curr..9).map { lastVisitedHeightIndices[it] }
                    .filter { it != -1 }
                    .maxOrNull()
                    ?.let { j - it } ?: i
                visible[i][j] = visible[i][j] * currVisibility

                max = max(max, curr)
                lastVisitedHeightIndices[curr] = j
            }
        }
    }


}