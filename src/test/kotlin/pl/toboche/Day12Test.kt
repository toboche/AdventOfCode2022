package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day12Test {
    @Test
    fun task1Example() {
        val input = ("Sabqponm\n" +
                "abcryxxl\n" +
                "accszExk\n" +
                "acctuvwj\n" +
                "abdefghi")
            .lines()
        assertEquals(
            31,
            Day12().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/day12Task.txt")
            .readText()
            .lines()

        assertEquals(
            490,
            Day12().task1(input)
        )
    }
}