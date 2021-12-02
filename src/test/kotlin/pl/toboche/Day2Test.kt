package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day2Test {
    @Test
    internal fun task2Example() {
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
}