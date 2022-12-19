package pl.toboche

import kotlin.math.max

class Day14 {

    fun task1(input: List<String>): Int {
        //x,y
        val pair = parseInput(input)
        val map = pair.first
        val lowest = pair.second
        var counter = 0
        var currentX = 500
        var currentY = 0
        while (currentY < lowest) {
            if (isFree(map, currentX, currentY + 1)) {
                currentY += 1
                continue
            } else if (isFree(map, currentX - 1, currentY + 1)) {
                currentX -= 1
                currentY += 1
            } else if (isFree(map, currentX + 1, currentY + 1)) {
                currentX += 1
                currentY += 1
            } else {
                addPointToMap(map, currentX, currentY)
                currentX = 500
                currentY = 0
                counter += 1
                printMap(map)
            }
        }
        return counter
    }

    fun task2(input: List<String>): Int {
        //x,y
        val pair = parseInput(input)
        val map = pair.first
        val lowest = pair.second
        val floor = lowest + 2
        var counter = 0
        var currentX = 500
        var currentY = 0
        while (true) {
            if (currentY + 1 == floor) {
                addPointToMap(map, currentX, currentY)
                currentX = 500
                currentY = 0
                counter += 1
                printMap(map)
                continue
            } else if (isFree(map, currentX, currentY + 1)) {
                currentY += 1
                continue
            } else if (isFree(map, currentX - 1, currentY + 1)) {
                currentX -= 1
                currentY += 1
            } else if (isFree(map, currentX + 1, currentY + 1)) {
                currentX += 1
                currentY += 1
            } else {
                addPointToMap(map, currentX, currentY)
                if (currentY == 0) {
                    counter += 1
                    break
                }
                currentX = 500
                currentY = 0
                counter += 1
                printMap(map)
            }
        }
        return counter
    }

    private fun parseInput(input: List<String>): Pair<MutableMap<Int, MutableSet<Int>>, Int> {
        val map = mutableMapOf<Int, MutableSet<Int>>()
        var lowest = 0
        input.forEach { line ->
            line.split(" -> ")
                .map {
                    it.split(",")
                        .let {
                            it[0].toInt() to it[1].toInt()
                        }
                }.windowed(2, 1)
                .forEach { it ->
                    val start = it[0]
                    val end = it[1]
                    lowest = max(lowest, max(start.second, end.second))
                    val xVector = if (start.first < end.first) {
                        start.first.rangeTo(end.first)
                    } else {
                        end.first.rangeTo(start.first)
                    }

                    val yVector = if (start.second < end.second) {
                        start.second.rangeTo(end.second)
                    } else {
                        end.second.rangeTo(start.second)
                    }

                    val vector = xVector.flatMap { x -> yVector.map { y -> x to y } }
                    vector.forEach { (x, y) ->
                        addPointToMap(map, x, y)
                    }
                }
        }
        return Pair(map, lowest)
    }

    private fun printMap(map: MutableMap<Int, MutableSet<Int>>) {
//        map.toSortedMap().forEach {  }
    }

    private fun addPointToMap(
        map: MutableMap<Int, MutableSet<Int>>,
        x: Int,
        y: Int
    ) {
        map.compute(x) { _, value ->
            (value ?: mutableSetOf()).let {
                it.add(y)
                it
            }
        }
    }

    private fun isFree(
        map: MutableMap<Int, MutableSet<Int>>,
        currentX: Int,
        currentY: Int
    ) = map[currentX]?.contains(currentY)?.not() ?: true

}