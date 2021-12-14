package pl.toboche

class Day14 {
    fun task1String(input: List<String>, steps: Int = 10): Int {
        val template = input.first()

        val mappings = input.drop(2).associate {
            val (adjacent, mapped) = it.split(" -> ")
            adjacent to mapped
        }

        return (1..steps).fold(template) { state, a ->
            state[0] + state.windowed(2, 1, false)
                .map<String, Any> { if (mappings.contains(it)) mappings[it]!! + it[1] else it[1] }
                .joinToString("")

        }.fold(IntArray(26)) { acc, char ->
            acc[char.code - 'A'.code] += 1
            acc
        }.sorted().let {
            it.last() - it.first { it > 0 }
        }
    }

}