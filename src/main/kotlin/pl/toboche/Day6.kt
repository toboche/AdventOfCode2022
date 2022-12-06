package pl.toboche

class Day6 {

    fun task1(input: String): Int {
        val lastFour = mutableListOf<Char>()
        input.forEachIndexed { index, char ->
            if (lastFour.count() >= 4) {
                lastFour.removeFirst()
            }
            lastFour.add(char)
            if (lastFour.distinct().count() == 4) {
                return index + 1
            }
        }
        return -1
    }
}