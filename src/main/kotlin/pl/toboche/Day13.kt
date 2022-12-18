package pl.toboche

class Day13 {

    fun task1(input: List<String>, anySquare: Boolean = false): Int {
        val topLines = input.windowed(3, 3, true)
            .map { it[0] to it[1] }
            .map { mapToList(it.first).first to mapToList(it.second).first }
            .mapIndexed { index, pair ->
                if (compare(pair.first, pair.second) > 0) {
                    index + 1
                } else {
                    0
                }
            }.sum()

        return topLines
    }

    private fun compare(left: List<Any>, right: List<Any>): Int {
        val indices = if (left.size > right.size) left.indices else right.indices

        indices.forEach { i ->
            val leftE = left.getOrNull(i) ?: return 1
            val rightE = right.getOrNull(i) ?: return 0

            if (leftE is Int && rightE is Int) when {
                leftE < rightE -> return 1
                leftE == rightE -> return@forEach
                else -> return 0
            }

            @Suppress("UNCHECKED_CAST")
            val subResult = when {
                leftE is List<*> && rightE is List<*> -> compare(leftE as List<Any>, rightE as List<Any>)
                leftE is Int -> compare(listOf(leftE), rightE as List<Any>)
                else -> compare(leftE as List<Any>, listOf(rightE))
            }
            when (subResult) {
                1 -> return 1
                0 -> return 0
                -1 -> return@forEach
            }
        }
        return -1
    }

    fun mapToList(packet: String, startIndex: Int = 0): Pair<List<Any>, Int> {
        val result = mutableListOf<Any>()
        var currentIndex = startIndex
        val currentNumber = StringBuilder()

        while (currentIndex <= packet.lastIndex) {
            when (val currentChar = packet[currentIndex]) {
                '[' -> {
                    val subPacket = mapToList(packet, currentIndex + 1)
                    result.add(subPacket.first)
                    currentIndex = subPacket.second
                }

                ']' -> {
                    if (currentNumber.isNotEmpty()) result.add(currentNumber.toString().toInt())
                    return Pair(result, currentIndex + 1)
                }

                ',' -> {
                    if (currentNumber.isNotEmpty()) result.add(currentNumber.toString().toInt())
                    currentNumber.clear()
                    currentIndex++
                }

                else -> {
                    currentNumber.append(currentChar)
                    currentIndex++
                }
            }
        }
        if (currentNumber.isNotEmpty()) result.add(currentNumber.toString().toInt())
        return Pair(result, currentIndex)
    }

}