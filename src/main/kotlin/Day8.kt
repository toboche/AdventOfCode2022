class Day8 {
    fun task1(input: List<String>): Int {
        return input.sumOf {
            it.split("|")[1]
                .split(" ")
                .count { listOf(2, 4, 3, 7).contains(it.trim().length) }
        }
    }

}