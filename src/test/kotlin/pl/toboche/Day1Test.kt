package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day1Test {
    @Test
    internal fun task1Example() {
        val input = ("1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000\n" +
                "\n" +
                "5000\n" +
                "6000\n" +
                "\n" +
                "7000\n" +
                "8000\n" +
                "9000\n" +
                "\n" +
                "10000")
            .lines()
        assertEquals(
            24000,
            Day1().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day1Task1.txt")
            .readText()
            .lines()

        assertEquals(
            69206,
            Day1().task1(input)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000\n" +
                "\n" +
                "5000\n" +
                "6000\n" +
                "\n" +
                "7000\n" +
                "8000\n" +
                "9000\n" +
                "\n" +
                "10000")
            .lines()
        assertEquals(
            45000,
            Day1().task2(input)
        )
    }

}