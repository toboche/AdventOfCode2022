package pl.toboche

class Day3 {
    fun task1(input: List<String>): Int {
        val bits = input[0].length
        val ones = IntArray(bits)
        input.forEach {
            it.forEachIndexed { index, c ->
                ones[index] += if (c == '1') 1 else 0
            }
        }
        val halfOfValues = input.size / 2
        return replaceMostCommonOccurrences(ones,
            halfOfValues,
            '1',
            '0') *
                replaceMostCommonOccurrences(ones,
                    halfOfValues,
                    '0',
                    '1')
    }

    private fun replaceMostCommonOccurrences(ones: IntArray, halfOfValues: Int, mostCommon: Char, leastCommon: Char) =
        ones.map { if (it > halfOfValues) mostCommon else leastCommon }
            .joinToString("")
            .toInt(2)
}