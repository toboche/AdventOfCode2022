package pl.toboche

class Day6 {

    fun task1(input: String, count: Int): Int {
        val lastFour = mutableListOf<Char>()
        input.forEachIndexed { index, char ->
            if (lastFour.count() >= count) {
                lastFour.removeFirst()
            }
            lastFour.add(char)
            if (lastFour.distinct().count() == count) {
                return index + 1
            }
        }
        return -1
    }
}