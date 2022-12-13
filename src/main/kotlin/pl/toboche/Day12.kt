package pl.toboche

import java.lang.Math.abs
import kotlin.math.min

class Day12 {

    fun task1(input: List<String>): Int {
        val map = input.map { it.toCharArray() }.toTypedArray()
        val Sx = input.withIndex().first { it.value.contains('S') }.index
        val Sy = input[Sx].indexOf('S')
        val S = Sx to Sy
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
            queue.remove(u)

            val currentHeight = map[u.first][u.second].let {
                if (it == 'S') 'a' else if (it == 'E') 'z' else it
            }
            listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
                .map { it.copy(it.first + u.first, it.second + u.second) }
                .map { vector ->
                    map.getOrNull(vector.first)?.getOrNull(vector.second)?.let {
                        if (it == 'S') 'a' else if (it == 'E') 'z' else it
                    }?.let { it to vector }
                }.filterNotNull()
                .filter { abs(it.first - currentHeight) <= 1 }
                .forEach {
                    if (dist[u.first][u.second] + 1 < dist[it.second.first][it.second.second]) {
                        dist[it.second.first][it.second.second] = dist[u.first][u.second] + 1
                        prev[it.second.first][it.second.second] = u
                    }
                }

        }

        val E = find(input, 'E')
        var prevItem: Pair<Int, Int>? = E
        var count = -1
        while (prevItem != null) {
            prevItem = prev[prevItem.first][prevItem.second]
            count += 1
        }
        return count
    }

    private fun findMinDistance(dist: Array<IntArray>, queue: MutableList<Pair<Int, Int>>): Pair<Int, Int> {
        var minDist: Int? = null
        var mindDistItem = -1 to -1
        for (queueItem in queue) {
            if (minDist == null || dist[queueItem.first][queueItem.second] < minDist) {
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
}