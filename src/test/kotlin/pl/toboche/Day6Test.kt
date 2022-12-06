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
            Day6().task1(input, 4)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/Day6Task1.txt")
            .readText()

        assertEquals(
            1142,
            Day6().task1(input, 4)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        assertEquals(
            19,
            Day6().task1(input, 14)
        )
    }

}