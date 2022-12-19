package pl.toboche

import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.math.abs

class Day15 {

    fun task1(input: List<String>, rowToCheck: Int): Int {
        val (beacons, map) = map(input)
        val merged = allRangesForRow(map, rowToCheck)
        val beaconsInRow = beacons.count {
            it.second == rowToCheck
        }

        return merged.sumOf { it.count() } - beaconsInRow
    }

    private fun map(input: List<String>): Pair<MutableSet<Pair<Int, Int>>, List<Pair<Pair<Int, Int>, Int>>> {
        val beacons = mutableSetOf<Pair<Int, Int>>()
        val map = input.map {
            val sX = it.substringAfter("Sensor at x=")
                .substringBefore(",")
                .toInt()

            val sY = it.substringAfter(", y=")
                .substringBefore(": ")
                .toInt()

            val beaconString = it.substringAfter("closest beacon is at x=")

            val bX = beaconString.substringBefore(", ")
                .toInt()
            val bY = beaconString.substringAfter(", y=")
                .toInt()
            beacons.add(bX to bY)
            val center = sX to sY
            val diameterAtCenter = abs(sX - bX) + abs(sY - bY)
            center to diameterAtCenter
        }
        return Pair(beacons, map)
    }

    private fun allRangesForRow(
        map: List<Pair<Pair<Int, Int>, Int>>,
        rowToCheck: Int
    ): List<IntRange> {
        val filter = map.filter { (center, diameterAtCenter) ->
            center.second.rangeTo(center.second + diameterAtCenter)
                .contains(rowToCheck) || (center.second - diameterAtCenter).rangeTo(center.second).contains(rowToCheck)
        }
        val separateRanges = filter.map { (center, diameterAtCenter) ->
            val startX = center.first - (diameterAtCenter - abs(center.second - rowToCheck))
            val endX = center.first + (diameterAtCenter - abs(center.second - rowToCheck))
            startX.rangeTo(endX)
        }

        val sorted = separateRanges.sortedBy { it.last }.sortedBy { it.first }
        val merged = sorted.fold(emptyList<IntRange>()) { acc, it ->
            val lastOrNull = acc.lastOrNull()
            if (lastOrNull?.contains(it.first) == true) {
                acc.dropLast(1).plusElement(lastOrNull.first.rangeTo(max(it.last, lastOrNull.last)))
            } else {
                acc.plusElement(it)
            }
        }
        return merged
    }

    fun task2(input: List<String>, upperLimit: Int): Long {
        val (_, map) = map(input)
        for (rowToCheck in 0..upperLimit) {
            val merged = allRangesForRow(map, rowToCheck)
            val first = merged.first { it.first <= 0 }
            if (first.last < upperLimit) {
                return 4000000L * (first.last.toLong() + 1L) + rowToCheck.toLong()
            }
        }

        return -1
    }
}