package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day10Test {
    @Test
    fun task1Example() {
        val input = ("noop\n" +
                "addx 3\n" +
                "addx -5")
            .lines()
        assertEquals(
            0,
            Day10().task1(input).first
        )
    }

    @Test
    fun task1Example2() {
        val input = File("src/test/resources/day10Example.txt")
            .readText()
            .lines()

        assertEquals(
            13140,
            Day10().task1(input).first
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/day10Task1.txt")
            .readText()
            .lines()

        assertEquals(
            12640,
            Day10().task1(input).first
        )
    }

    @Test
    fun task2Example() {
        val input = File("src/test/resources/day10Example.txt")
            .readText()
            .lines()

        val actual = Day10().task1(input).second

        assertEquals(
            "##..##..##..##..##..##..##..##..##..##..\n" +
                    "###...###...###...###...###...###...###.\n" +
                    "####....####....####....####....####....\n" +
                    "#####.....#####.....#####.....#####.....\n" +
                    "######......######......######......####\n" +
                    "#######.......#######.......#######.....",
            actual
        )
    }

    @Test
    fun task2() {
        val input = File("src/test/resources/day10Task1.txt")
            .readText()
            .lines()

        val actual = Day10().task1(input).second

        assertEquals(
            "####.#..#.###..####.#....###....##.###..\n" +
                    "#....#..#.#..#....#.#....#..#....#.#..#.\n" +
                    "###..####.###....#..#....#..#....#.#..#.\n" +
                    "#....#..#.#..#..#...#....###.....#.###..\n" +
                    "#....#..#.#..#.#....#....#.#..#..#.#.#..\n" +
                    "####.#..#.###..####.####.#..#..##..#..#.",
            actual
        )
    }
}