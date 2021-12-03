package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day3Test {
    @Test
    internal fun task1Example() {
        val input = ("00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010")
            .lines()

        assertEquals(198,
            Day3().task1(input))
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day3Task1.txt")
            .readLines()

        assertEquals(3895776,
            Day3().task1(input))
    }

    @Test
    internal fun task2Example() {
        val input = ("00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010")
            .lines()

        assertEquals(230,
            Day3().task2(input))
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day3Task1.txt")
            .readLines()

        assertEquals(7928162,
            Day3().task2(input))
    }
}