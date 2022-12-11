package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day10Test {
    @Test
    fun task1Example() {
        val input = ("noop\n" +
                "addx 3\n" +
                "addx -5")
            .lines()
        assertEquals(
            0,
            Day10().task1(input)
        )
    }

    @Test
    fun task1Example2() {
        val input = File("src/test/resources/day10Example.txt")
            .readText()
            .lines()

        //5764 - wrong
        assertEquals(
            13140,
            Day10().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/day10Task1.txt")
            .readText()
            .lines()

        //5764 - wrong
        assertEquals(
            12640,
            Day10().task1(input)
        )
    }
}