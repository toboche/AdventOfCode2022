package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day5Test {
    @Test
    internal fun task1Example() {
        val input = ("    [D]    \n" +
                "[N] [C]    \n" +
                "[Z] [M] [P]\n" +
                " 1   2   3 \n" +
                "\n" +
                "move 1 from 2 to 1\n" +
                "move 3 from 1 to 3\n" +
                "move 2 from 2 to 1\n" +
                "move 1 from 1 to 2")
            .lines()
        assertEquals(
            "CMZ",
            Day5().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/Day5Task1.txt")
            .readText()
            .lines()

        assertEquals(
            "VQZNJMWTR",
            Day5().task1(input)
        )
    }
}