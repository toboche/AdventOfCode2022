package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day4Test {
    @Test
    internal fun task1Example() {
        val input = File("src/test/resources/day4Example1.txt")
            .readLines()

        assertEquals(4512,
            Day4().task1(input))
    }

}