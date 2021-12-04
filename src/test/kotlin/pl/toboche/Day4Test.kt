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

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day4Task1.txt")
            .readLines()

        assertEquals(10680,
            Day4().task1(input))
    }

    @Test
    internal fun task2Example() {
        val input = File("src/test/resources/day4Example1.txt")
            .readLines()

        assertEquals(1924,
            Day4().task2(input))
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day4Task1.txt")
            .readLines()

        assertEquals(31892,
            Day4().task2(input))
    }

}