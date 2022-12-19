package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day14Test {
    @Test
    fun task1Example() {
        val input = ("498,4 -> 498,6 -> 496,6\n" +
                "503,4 -> 502,4 -> 502,9 -> 494,9")
            .lines()

        assertEquals(
            24,
            Day14().task1(input)
        )
    }
    @Test
    fun task1() {
        val input = File("src/test/resources/day14Task.txt")
            .readText()
            .lines()

        assertEquals(
            644,
            Day14().task1(input)
        )
    }


}