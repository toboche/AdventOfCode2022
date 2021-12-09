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

        return array.mapIndexed { y, ints ->
            ints.withIndex().filter { (x, value) ->
                ds.map { (dx, dy) ->
                    x + dx to y + dy
                }.filter { (nx, ny) ->
                    xBounds.contains(nx) && yBounds.contains(ny)
                }
                    .all { (nx, ny) -> array[ny][nx] > value }
            }.sumOf { it.value + 1 }
        }.sum()
    }
}