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

    @Test
    fun task2Example() {
        val input = File("src/test/resources/day11Example.txt")
            .readText()
            .lines()

        assertEquals(
            2713310158,
            Day11().task1(input, 10000, false)
        )
    }

    @Test
    fun task2() {
        val input = File("src/test/resources/day11Task.txt")
            .readText()
            .lines()

        //32396760077 too high
        //32390460700 too high
        assertEquals(
            29703395016,
            Day11().task1(input, 10000, false)
        )
    }
}