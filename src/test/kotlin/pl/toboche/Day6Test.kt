package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day6Test {
    @Test
    internal fun task1Example() {
        val input = ("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        assertEquals(
            7,
            Day6().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/Day6Task1.txt")
            .readText()

        assertEquals(
            123,
            Day6().task1(input)
        )
    }
}