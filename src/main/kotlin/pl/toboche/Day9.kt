package pl.toboche

class Day9 {

    val ds = listOf(
        -1 to 0,
        1 to 0,
        0 to -1,
        0 to 1
    )

    fun task1(input: List<String>): Int {
        val array = input.map { it.map { it.digitToInt() }.toIntArray() }.toTypedArray()

        val yBounds = array.indices
        val xBounds = array[0].indices

        return findLocalMinima(array, xBounds, yBounds)
            .sumOf { it.sumOf { it.value + 1 } }
    }

    private fun findLocalMinima(
        array: Array<IntArray>,
        xBounds: IntRange,
        yBounds: IntRange,
    ) = array.mapIndexed { y, ints ->
        ints.withIndex().filter { (x, value) ->
            allNeighbors(x, y, xBounds, yBounds)
                .all { (nx, ny) -> array[ny][nx] > value }
        }
    }

    private fun allNeighbors(
        x: Int,
        y: Int,
        xBounds: IntRange,
        yBounds: IntRange,
    ) = ds.map { (dx, dy) ->
        x + dx to y + dy
    }.filter { (nx, ny) ->
        xBounds.contains(nx) && yBounds.contains(ny)
    }

    fun task2(input: List<String>): Int {
        val array = input.map { it.map { it.digitToInt() }.toIntArray() }.toTypedArray()

        val yBounds = array.indices
        val xBounds = array[0].indices

        return findLocalMinima(array, xBounds, yBounds).withIndex()
            .map { (y, minima) ->
                minima.map { (x, minimum) ->
                    val visited = mutableSetOf<Pair<Int, Int>>()
                    val convergent = mutableSetOf<Pair<Int, Int>>()
                    val toCheck = mutableListOf<Pair<Int, Int>>()
                    toCheck.add(x to y)
                    while (toCheck.isNotEmpty()) {
                        val current = toCheck.removeFirst()
                        visited.add(current)
                        if (array[current.second][current.first] != 9) {
                            convergent.add(current)
                            toCheck
                                .addAll(allNeighbors(current.first, current.second, xBounds, yBounds) - visited)
                        }
                    }
                    convergent.count()
                }
            }.flatten()
            .sorted()
            .reversed()
            .let {
                it[0] * it[1] * it[2]
            }
    }
}