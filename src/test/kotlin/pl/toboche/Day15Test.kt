package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day15Test {
    @Test
    fun task1Example() {
        val input = File("src/test/resources/day15Example.txt")
            .readText()
            .lines()

        assertEquals(
            26,
            Day15().task1(input, 10)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/day15Task.txt")
            .readText()
            .lines()

        assertEquals(
            4879972,
            Day15().task1(input, 2000000)
        )
    }

    @Test
    fun task2Example() {
        val input = File("src/test/resources/day15Example.txt")
            .readText()
            .lines()

        assertEquals(
            56000011,
            Day15().task2(input, 20)
        )
    }

    @Test
    fun task2() {
        val input = File("src/test/resources/day15Task.txt")
            .readText()
            .lines()

        assertEquals(
            12525726647448,
            Day15().task2(input, 4000000)
        )
    }
}