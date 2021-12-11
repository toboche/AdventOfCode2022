package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day11Test {

    private val example = "5483143223\n" +
            "2745854711\n" +
            "5264556173\n" +
            "6141336146\n" +
            "6357385478\n" +
            "4167524645\n" +
            "2176841721\n" +
            "6882881134\n" +
            "4846848554\n" +
            "5283751526\n"

    @Test
    internal fun task1Example() {
        val input = example
            .lines()

        assertEquals(0,
            Day11().task1(input, steps = 1))
    }

    @Test
    internal fun task1Example2() {
        val input = example
            .lines()

        assertEquals(35,
            Day11().task1(input, steps = 2))
    }

    @Test
    internal fun task1Example0() {
        val input = ("11111\n" +
                "19991\n" +
                "19191\n" +
                "19991\n" +
                "11111\n")
            .lines()

        assertEquals(9,
            Day11().task1(input, steps = 1))
    }
}