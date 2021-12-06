package pl.toboche

class Day6 {
    fun task1(input: String, iterations: Int = 80): Int {
        val fishTimerToFishCount = input.split(",")
            .map { it.toInt() }
            .groupBy { it }
            .map { it.key to it.value.count() }
            .toMap()

        return (1..iterations).fold(fishTimerToFishCount) { fish, day ->
            var newCount = 0
            val newFish = fish.map { (timer, count) ->
                val newTimer = when (timer) {
                    in 1..8 -> {
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