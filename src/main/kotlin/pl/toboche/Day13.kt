package pl.toboche

class Day13 {
    fun task1(input: List<String>): Int {
        val yFold = input.first { it.startsWith("fold along y=") }.substringAfter("fold along y=").toInt()
        val xFold = input.first { it.startsWith("fold along x=") }.substringAfter("fold along x=").toInt()
        val fold = input.take(input.size - 3)
            .fold(emptySet<Pair<Int, Int>>()) { set, it ->
                val (x, y) = it.split(",")
                    .map { it.toInt() }
                set + if (y > yFold) {
                    x to (y - yFold + 1)
                } else {
                    x to y
                }
            }
        return fold
            .size
    }

}