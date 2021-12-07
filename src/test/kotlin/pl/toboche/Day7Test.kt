package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day7Test {
    @Test
    internal fun task1Example1() {
        val input = "16,1,2,0,4,2,7,1,2,14"

        assertEquals(37,
            Day7().task1(input))
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day7Task1.txt")
            .readLines()[0]

        assertEquals(336701,
            Day7().task1(input))
    }

    @Test
    internal fun task2Example1() {
        val input = "16,1,2,0,4,2,7,1,2,14"

        assertEquals(168,
            Day7().task2(input))
    }

}