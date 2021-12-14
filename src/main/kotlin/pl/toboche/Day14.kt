package pl.toboche

class Day14 {
    fun task1String(input: List<String>, steps: Int = 10): Long {
        val template = input.first()
        val lastChar = template.last()

        val mappings = input.drop(2).associate {
            val (adjacent, mapped) = it.split(" -> ")
            adjacent to mapped.first()
        }

        var pairCount = template.windowed(2, 1, false).fold(mutableMapOf<String, Long>()) { acc, chars ->
            acc.compute(chars) { _, count ->
                (count ?: 0) + 1
            }
            acc
        }

        repeat(steps) {
            val newPairCount = mutableMapOf<String, Long>()
            pairCount.forEach { pair, count ->
                if (mappings.contains(pair)) {
                    newPairCount.compute("" + pair[0] + mappings[pair]!!) { key, value ->
                        (value ?: 0) + count
                    }
                    newPairCount.compute("" + mappings[pair]!! + pair[1]) { key, value ->
                        (value ?: 0) + count
                    }
                } else {
                    newPairCount[pair] = count
                }
            }
            pairCount = newPairCount
        }

        val counter = mutableMapOf<Char, Long>()
        pairCount.forEach { str, count ->
            str.take(1).forEach {
                counter.compute(it) { _, value ->
                    (value ?: 0) + count
                }
            }
        }
        return counter.map { (char, count) -> char to count }
            .groupBy({ it.first }, { it.second })
            .mapValues { it.value.sum() + if (it.key == lastChar) 1 else 0 }
            .values
            .sorted()
            .let { it.last() - it.first() }
    }

}