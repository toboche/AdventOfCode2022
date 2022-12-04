package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day4Test {
    @Test
    internal fun task1Example() {
        val input = ("2-4,6-8\n" +
                "2-3,4-5\n" +
                "5-7,7-9\n" +
                "2-8,3-7\n" +
                "6-6,4-6\n" +
                "2-6,4-8")
            .lines()
        assertEquals(
            2,
            Day4().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day4Task1.txt")
            .readText()
            .lines()

        assertEquals(
            507,
            Day4().task1(input)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("2-4,6-8\n" +
                "2-3,4-5\n" +
                "5-7,7-9\n" +
                "2-8,3-7\n" +
                "6-6,4-6\n" +
                "2-6,4-8")
            .lines()
        assertEquals(
            4,
            Day4().task2(input)
        )
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day4Task1.txt")
            .readText()
            .lines()

        assertEquals(
            897,
            Day4().task2(input)
        )
    }
}