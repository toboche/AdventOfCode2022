package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day1Test {
    @Test
    internal fun task1Example() {
        val input = ("199\n" +
                "200\n" +
                "208\n" +
                "210\n" +
                "200\n" +
                "207\n" +
                "240\n" +
                "269\n" +
                "260\n" +
                "263")
            .lines()
        assertEquals(7,
            Day1().task1(input))
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day1Task1.txt")
            .readText()
            .lines()

        assertEquals(1713,
            Day1().task1(input))
    }

    @Test
    internal fun task2Example() {
        val input = ("199\n" +
                "200\n" +
                "208\n" +
                "210\n" +
                "200\n" +
                "207\n" +
                "240\n" +
                "269\n" +
                "260\n" +
                "263")
            .lines()
        assertEquals(5,
            Day1().task2(input))
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day1Task1.txt")
            .readText()
            .lines()

        assertEquals(1734,
            Day1().task2(input))
    }
}