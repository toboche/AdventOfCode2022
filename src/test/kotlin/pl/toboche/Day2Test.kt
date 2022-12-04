package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2Test {
    @Test
    internal fun task1Example() {
        val input = ("A Y\n" +
                "B X\n" +
                "C Z")
            .lines()
        assertEquals(
            15,
            Day2().task1(input)
        )
    }

}