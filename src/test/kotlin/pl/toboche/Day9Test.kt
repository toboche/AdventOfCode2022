package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day9Test {
    @Test
    internal fun task1Example() {
        val input = File("src/test/resources/day9Example.txt")
            .readLines()

        assertEquals(15,
            Day9().task1(input))
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day9Task1.txt")
            .readLines()

        assertEquals(560,
            Day9().task1(input))
    }

    @Test
    internal fun task2Example() {
        val input = File("src/test/resources/day9Example.txt")
            .readLines()

        assertEquals(1134,
            Day9().task2(input))
    }
}
