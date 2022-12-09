package pl.toboche

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
    fun task2ExampleSingleLineSingleRun() {
        val input = listOf("30373")
        val visible = Array(input.size) { IntArray(input[0].length) { _ -> 1 } }

        Day8().traverseVisibilityHorizontally(input, visible, 0 until input.size, 0 until input[0].length)

        assertArrayEquals(
            Array(1) { intArrayOf(0, 1, 2, 3, 1) },
            visible
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