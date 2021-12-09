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

}
