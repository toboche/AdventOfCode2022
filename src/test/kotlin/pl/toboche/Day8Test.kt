package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day8Test {
    @Test
    fun task1Example() {
        val input = ("30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390")
            .lines()
        assertEquals(
            21,
            Day8().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/Day8Task1.txt")
            .readText()
            .lines()

        assertEquals(
            1812,
            Day8().task1(input)
        )
    }

    @Test
    fun task2Example() {
        val input = ("30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390")
            .lines()
        assertEquals(
            8,
            Day8().task2(input)
        )
    }
}