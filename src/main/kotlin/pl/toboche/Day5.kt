package pl.toboche

class Day5 {
    fun task1(input: List<String>): Int {
        val fold = input.asSequence()
            .map {
                mapLine(it)
            }
            .filter {
                it.first.first == it.second.first
                        || it.first.second == it.second.second
            }
            .map { allPoints(it) }
            .flatten()
            .fold(mutableMapOf<Pair<Int, Int>, Int>()) { acc, point ->
                acc.compute(point) { key, value ->
                    (value ?: 0) + 1
                }
                acc
            }
        return fold
            .filter { pointEntry -> pointEntry.value >= 2 }
            .count()
    }

    private fun allPoints(it: Pair<Pair<Int, Int>, Pair<Int, Int>>): List<Pair<Int, Int>> {
        val (x1, y1) = it.first
        val (x2, y2) = it.second
        return if (x1 == x2) {
            (y1 toward y2).map { y ->
                x1 to y
            }
        } else {
            (x1 toward x2).map { x ->
                x to y1
            }
        }
    }

    private infix fun Int.toward(to: Int): IntProgression {
        val step = if (this > to) -1 else 1
        return IntProgression.fromClosedRange(this, to, step)
    }

    internal fun mapLine(it: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        return it.split(" -> ")
            .map { points ->
                points.split(",")
                    .map { point -> point.toInt() }
                    .let { point ->
                        point[0] to point[1]
                    }
            }
            .let { points ->
                points[0] to points[1]
            }
    }
}