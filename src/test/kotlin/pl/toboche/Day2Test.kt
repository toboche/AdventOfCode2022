package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2Test {
    @Test
    internal fun task1Example() {
        val input = ("forward 5\n" +
                "down 5\n" +
                "forward 8\n" +
                "up 3\n" +
                "down 8\n" +
                "forward 2")
            .lines()

        assertEquals(150,
            Day2().task1(input))
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day2Task1.txt")
            .readLines()

        assertEquals(1670340,
            Day2().task1(input))
    }

    @Test
    internal fun task2Example() {
        val input = ("forward 5\n" +
                "down 5\n" +
                "forward 8\n" +
                "up 3\n" +
                "down 8\n" +
                "forward 2")
            .lines()

        assertEquals(900,
            Day2().task2(input))
    }
}