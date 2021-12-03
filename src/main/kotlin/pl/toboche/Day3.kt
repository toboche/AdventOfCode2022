package pl.toboche

class Day3 {
    fun task1(input: List<String>): Int {
        val ones = countOnes(input)
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

    private fun countOnes(input: List<String>): IntArray {
        val bits = input[0].length
        val ones = IntArray(bits)
        input.forEach {
            it.forEachIndexed { index, c ->
                ones[index] += if (c == '1') 1 else 0
            }
        }
        return ones
    }

    private fun findMostCommonValue(input: List<List<Boolean>>, index: Int): Boolean {
        var ones = 0
        input.forEach {
            ones += if (it[index]) 1 else 0
        }
        val halfOfValues = input.size / 2

        return if (halfOfValues * 2 == input.size && ones == halfOfValues) {
            true
        } else {
            ones > halfOfValues
        }
    }

    private fun findLeastCommonValue(input: List<List<Boolean>>, index: Int): Boolean {
        var ones = 0
        input.forEach {
            ones += if (it[index]) 1 else 0
        }
        val halfOfValues = input.size / 2

        return if (halfOfValues * 2 == input.size && ones == halfOfValues) {
            false
        } else {
            ones <= halfOfValues
        }
    }

    private fun replaceMostCommonOccurrences(ones: IntArray, halfOfValues: Int, mostCommon: Char, leastCommon: Char) =
        ones.map { if (it > halfOfValues) mostCommon else leastCommon }
            .joinToString("")
            .toInt(2)

    fun task2(input: List<String>): Int {
        return filterForCondition(input, ::findLeastCommonValue) * filterForCondition(input, ::findMostCommonValue)
    }

    private fun filterForCondition(
        input: List<String>,
        filteringCondition: (input: List<List<Boolean>>, index: Int) -> Boolean,
    ): Int {
        var filtered = input.map { it.map { it == '1' } }
        var iter = 0
        while (filtered.size != 1) {
            val mostCommonValue = filteringCondition(filtered, iter)
            filtered = filtered.filter { it[iter] == mostCommonValue }
            iter++
        }
        return filtered.first()
            .map { if (it) '1' else '0' }
            .joinToString("")
            .toInt(2)
    }

}