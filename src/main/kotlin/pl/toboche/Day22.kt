package pl.toboche

import java.lang.Integer.max
import java.lang.Integer.min

class Day22 {
    fun task1(input: String): Int {
        val cubes = mutableSetOf<Triple<Int, Int, Int>>()
        input.lines().forEach { line ->
            val splitBySpace = line.split(" ")
            val splitByComma = splitBySpace[1].split(",")
            range(splitByComma[0]).flatMap { x -> range(splitByComma[1]).map { y -> x to y } }
                .flatMap { xToY -> range(splitByComma[2]).map { Triple(xToY.first, xToY.second, it) } }
                .forEach {
                    if (splitBySpace[0] == "on") {
                        cubes.add(it)
                    } else {
                        cubes.remove(it)
                    }
                }
        }
        return cubes.count()
    }

    private fun range(s: String): IntRange {
        val (x1parsed, x2parsed) = s.drop(2).split("..").map { it.toInt() }
        val x1 = if (x1parsed < -50) {
            -50
        } else if (x1parsed > 50) {
            return IntRange.EMPTY
        } else {
            x1parsed
        }
        val x2 = if (x2parsed > 50) {
            50
        } else if (x2parsed < -50)
            return IntRange.EMPTY
        else {
            x2parsed
        }
        return x1..x2
    }

    data class Cuboid(
        val on: Boolean,
        val xRange: IntRange,
        val yRange: IntRange,
        val zRange: IntRange,
    )

}