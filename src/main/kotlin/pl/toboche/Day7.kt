package pl.toboche

import java.lang.Math.abs
import java.lang.Math.min

class Day7 {
    fun task1(input: String): Int {
        val positions = mapPositions(input)
        val median = findMedian(positions)
        return calculateFuelBurntConstantly(positions, median)
    }

    fun task2(input: String): Int {
        val positions = mapPositions(input)
        val mean = positions.average()
        return min(
            calculateFuelBurntLinearly(positions, mean.toInt()),
            calculateFuelBurntLinearly(positions, mean.toInt() + 1)
        )
    }

    private fun calculateFuelBurntLinearly(positions: List<Int>, toPosition: Int): Int {
        return positions.sumOf {
            linearCost(abs(toPosition - it))
        }
    }

    private fun linearCost(n: Int) =
        (n * (n + 1)) / 2


    private fun calculateFuelBurntConstantly(positions: List<Int>, median: Int): Int {
        return positions.sumOf {
            if (median > it) median - it
            else it - median
        }
    }

    private fun findMedian(positions: List<Int>): Int {
        val sorted = positions
            .sorted()
        val median = sorted[positions.count() / 2]
        return median
    }

    private fun mapPositions(input: String): List<Int> {
        val positions = input.split(",")
            .map { it.toInt() }
        return positions
    }
}