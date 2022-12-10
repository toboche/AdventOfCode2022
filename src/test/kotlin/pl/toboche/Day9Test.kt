package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day9Test {
    @Test
    fun task1Example() {
        val input = ("R 4\n" +
                "U 4\n" +
                "L 3\n" +
                "D 1\n" +
                "R 4\n" +
                "D 1\n" +
                "L 5\n" +
                "R 2")
            .lines()
        assertEquals(
            13,
            Day9().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/Day9Task1.txt")
            .readText()
            .lines()

        //5764 - wrong
        assertEquals(
            5513,
            Day9().task1(input)
        )
    }

    @Test
    fun task1ExampleInternal() {
        val input = ("R 4\n" +
                "U 4\n" +
                "L 3\n" +
                "D 1\n" +
                "R 4\n" +
                "D 1\n" +
                "L 5\n" +
                "R 2")
            .lines()
        val actual = Day9().task1Internal(input)
        val xMax = actual.maxBy { it.first }.first
        val yMax = actual.maxBy { it.second }.second + 2
        val visual = (0..xMax).map { x ->
            (0..yMax).map { y ->
                if (x == 0 && y == 0) {
                    's'
                } else if (actual.contains(y to x)) {
                    '#'
                } else {
                    '.'
                }
            }.joinToString("")
        }
            .asReversed()
            .joinToString("\n")

        assertEquals(
            13,
            actual.count()
        )

        assertEquals(
            "..##..\n" +
                    "...##.\n" +
                    ".####.\n" +
                    "....#.\n" +
                    "s###..",
            visual
        )

    }
}