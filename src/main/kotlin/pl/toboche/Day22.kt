package pl.toboche

class Day22 {
    fun task1(input: String): Int {
        val cubes = mutableSetOf<Triple<Int, Int, Int>>()
        input.lines().forEach { line ->
            val splitBySpace = line.split(" ")
            val splitByComma = splitBySpace[1].split(",")
//            Cuboid(
//                split[0] == "on", range(split[1]), range(split[2]), range(split[3])
//            )
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
        val (x1, x2) = s.drop(2).split("..").map { it.toInt() }
        return x1..x2
    }

    data class Cuboid(
        val on: Boolean,
        val xRange: IntRange,
        val yRange: IntRange,
        val zRange: IntRange,
    )

}