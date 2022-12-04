package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day3Test {
    @Test
    internal fun task1Example() {
        val input = ("vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw")
            .lines()
        assertEquals(
            157,
            Day3().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day3Task1.txt")
            .readText()
            .lines()

        assertEquals(
            69206,
            Day3().task1(input)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw")
            .lines()
        assertEquals(
            70,
            Day3().task2(input)
        )
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day3Task1.txt")
            .readText()
            .lines()

        assertEquals(
            69206,
            Day3().task2(input)
        )
    }
}