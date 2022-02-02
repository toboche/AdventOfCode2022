package pl.toboche

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
    private fun rangeNotCapped(s: String): IntRange {
        val (x1, x2) = s.drop(2).split("..").map { it.toInt() }
        return x1..x2
    }

    fun task2(input: String): Long {
        return input.lines().map { line ->
            val splitBySpace = line.split(" ")
            val splitByComma = splitBySpace[1].split(",")
            Cuboid(
                splitBySpace[0] == "on",
                rangeNotCapped(splitByComma[0]),
                rangeNotCapped(splitByComma[1]),
                rangeNotCapped(splitByComma[2])
            )
        }.fold(listOf<Cuboid>()) { currentCubes, cube ->
            (currentCubes + currentCubes.mapNotNull { it.intersection(cube) }).let {
                if (cube.on) {
                    it + cube
                } else {
                    it
                }
            }
        }.sumOf {
            volume(it)
        }
    }

    private fun volume(it: Cuboid) =
        (it.xRange.size().toLong() * it.yRange.size().toLong() * it.zRange.size().toLong()) * if (it.on) 1 else -1

    data class Cube(
        val xRange: IntRange,
        val yRange: IntRange,
        val zRange: IntRange,
    )


    data class Cuboid(
        val on: Boolean,
        val xRange: IntRange,
        val yRange: IntRange,
        val zRange: IntRange,
    ) {
        fun intersection(cube: Cuboid): Cuboid? {
            return if (xRange.intersectsRange(cube.xRange) &&
                yRange.intersectsRange(cube.yRange) &&
                zRange.intersectsRange(cube.zRange)
            ) {
                Cuboid(
                    !on,
                    maxOf(xRange.first, cube.xRange.first)..minOf(xRange.last, cube.xRange.last),
                    maxOf(yRange.first, cube.yRange.first)..minOf(yRange.last, cube.yRange.last),
                    maxOf(zRange.first, cube.zRange.first)..minOf(zRange.last, cube.zRange.last),
                )
            } else {
                null
            }
        }
    }

}

private fun IntRange.size() = last - first + 1


private fun IntRange.intersectsRange(range: IntRange) = first <= range.last && last >= range.first
