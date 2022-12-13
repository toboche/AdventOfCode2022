package pl.toboche

import java.lang.Math.abs
import kotlin.math.min

class Day12 {

    fun task1(input: List<String>, anySquare: Boolean = false): Int {
        val map = input.map { it.toCharArray() }.toTypedArray()
        val Sx = input.withIndex().first { it.value.contains('S') }.index
        val Sy = input[Sx].indexOf('S')
        val S = Sx to Sy
        return task1Internal(input, S, map, anySquare)[S]!!
    }

    private fun task1Internal(
        input: List<String>,
        S: Pair<Int, Int>,
        map: Array<CharArray>,
        anySquare: Boolean
    ): Map<Pair<Int,Int>, Int> {
        val dist = Array(input.size) { _ -> IntArray(input[0].length) { _ -> Int.MAX_VALUE } }
        val prev = Array(input.size) { _ -> Array<Pair<Int, Int>?>(input[0].length) { _ -> null } }
        val queue = mutableListOf<Pair<Int, Int>>()
        dist[S.first][S.second] = 0

        for (x in input.indices) {
            val line = input[x]
            for (y in line.indices) {
                queue.add(x to y)
            }
        }

        while (queue.isNotEmpty()) {
            val u = findMinDistance(dist, queue)
            if (u == -1 to -1) {
                break
            }
            queue.remove(u)

            val currentHeight = charHeight(map, u)!!
            listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
                .map { it.copy(it.first + u.first, it.second + u.second) }
                .map { coords ->
                    charHeight(map, coords)?.let { it to coords }
                }.filterNotNull()
                .filter {
                    ((anySquare && currentHeight >= it.first) || currentHeight - it.first >= -1) && queue.contains(
                        it.second
                    )
                }
                .forEach {
                    if (dist[u.first][u.second] + 1 < dist[it.second.first][it.second.second]) {
                        dist[it.second.first][it.second.second] = dist[u.first][u.second] + 1
                        prev[it.second.first][it.second.second] = u
                    }
                }

        }

        val E = find(input, 'E')
        if (prev[E.first][E.second] == null) {
            return emptyMap()
        }
        var prevItem: Pair<Int, Int>? = E
        var count = 0
        val asToCount = mutableMapOf<Pair<Int, Int>, Int>()
        while (prevItem != S) {
            prevItem = prev[prevItem!!.first][prevItem.second]
            count += 1
            if (prevItem != null && charHeight(map,prevItem) == 'a') {
                asToCount[prevItem] = count
            }
        }
        return asToCount
    }

    private fun charHeight(map: Array<CharArray>, vector: Pair<Int, Int>): Char? {
        return map.getOrNull(vector.first)?.getOrNull(vector.second)?.let {
            if (it == 'S') 'a' else if (it == 'E') 'z' else it
        }
    }

    private fun findMinDistance(dist: Array<IntArray>, queue: MutableList<Pair<Int, Int>>): Pair<Int, Int> {
        var minDist: Int = Int.MAX_VALUE
        var mindDistItem = -1 to -1
        for (queueItem in queue) {
            if (dist[queueItem.first][queueItem.second] < minDist && dist[queueItem.first][queueItem.second] != Int.MAX_VALUE) {
                minDist = dist[queueItem.first][queueItem.second]
                mindDistItem = queueItem
            }
        }
        return mindDistItem
    }

    private fun find(input: List<String>, char: Char): Pair<Int, Int> {
        val Sx = input.withIndex().first { it.value.contains(char) }.index
        val Sy = input[Sx].indexOf(char)
        return Pair(Sx, Sy)
    }

    fun task2(input: List<String>, anySquare: Boolean = false): Int {
        val map = input.map { it.toCharArray() }.toTypedArray()
        val a = mutableListOf<Pair<Int, Int>>()
        for (x in input.indices) {
            val line = input[x]
            for (y in line.indices) {
                if (map[x][y] == 'a') {
                    a.add(x to y)
                }
            }
        }
        val Sx = input.withIndex().first { it.value.contains('S') }.index
        val Sy = input[Sx].indexOf('S')
        val S = Sx to Sy
        val currentAs = (a + S).toMutableList()
        var min = Int.MAX_VALUE
        while (currentAs.isNotEmpty()) {
            val allCounts = task1Internal(input, currentAs.first(), map, anySquare)
            if (allCounts.isEmpty()) {
                currentAs.removeFirst()
                continue
            }
            currentAs.removeAll(allCounts.keys)
            min = min(min, allCounts.values.min())
        }
        return min
    }
}