package pl.toboche

class Day11 {

    val adjacentVectors = (-1..1).flatMap { x -> (-1..1).map { x to it } } - (0 to 0)

    fun task1(input: List<String>, steps: Int): Int {
        var oldState = input.map { it.map { it.digitToInt() }.toIntArray() }.toTypedArray()

        var flashes = 0

        (1..steps).forEach {
            val newState = Array(10) { IntArray(10) }

            oldState.indices.forEach { y ->
                oldState[y].indices.forEach { x ->
                    newState[x][y] = oldState[x][y] + 1
                }
            }
            var newStateContainsNewFlashes = newState.find { it.find { it > 9 } != null } != null
            while (newStateContainsNewFlashes) {
                newStateContainsNewFlashes = false
                newState.indices.forEach { y ->
                    newState[y].indices.forEach { x ->
                        if (newState[x][y] > 9) {
                            newStateContainsNewFlashes = true
                            flashes += 1
                            newState[x][y] = 0
                            adjacentVectors
                                .map { (dx, dy) -> x + dx to y + dy }
                                .filter { (x, y) -> x in 0..9 && y in 0..9 }
                                .forEach { (x, y) ->
                                    if (newState[x][y] > 0) {
                                        newState[x][y] += 1
                                    }
                                }
                        }
                    }
                }
            }
            oldState = newState
        }
        return flashes
    }
}