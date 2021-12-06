package pl.toboche

class Day6 {
    fun task1(input: String, iterations: Int = 80): Long {
        val fishTimerToFishCount = input.split(",")
            .map { it.toInt() }
            .groupBy { it }
            .map { it.key to it.value.count().toLong() }
            .toMap()

        return (1..iterations).fold(fishTimerToFishCount) { fish, day ->
            var newCount = 0L
            val newFish = fish.map { (timer, count) ->
                val newTimer = when (timer) {
                    in 1L..8L -> {
                        timer - 1
                    }
                    0 -> {
                        newCount = count
                        6
                    }
                    else -> throw Exception()
                }
                if (timer == 7) {
                    newTimer to count + newCount
                } else {
                    newTimer to count
                }
            }
                .toMap()
                .toMutableMap()
                .toSortedMap()
            newFish[8] = newCount
            newFish
        }
            .entries
            .sumOf { it.value }
    }
}