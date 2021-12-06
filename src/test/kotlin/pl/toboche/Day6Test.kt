package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day6Test {

    @Test
    internal fun task1Example1() {
        val input = "3,4,3,1,2"

        assertEquals(26,
            Day6().task1(input, 18))
    }

    @Test
    internal fun task1Example() {
        val input = "3,4,3,1,2"

        assertEquals(5934,
            Day6().task1(input))
    }
}