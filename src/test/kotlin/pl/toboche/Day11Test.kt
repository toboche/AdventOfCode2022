package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day11Test {
    @Test
    fun task1Example() {
        val input = File("src/test/resources/day11Example.txt")
            .readText()
            .lines()

        assertEquals(
            10605,
            Day11().task1(input, 20)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/day11Task.txt")
            .readText()
            .lines()

        assertEquals(
            113232,
            Day11().task1(input, 20)
        )
    }
}