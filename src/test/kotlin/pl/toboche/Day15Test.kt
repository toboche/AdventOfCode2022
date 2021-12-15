package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class Day15Test {

    private val example = "1163751742\n" +
            "1381373672\n" +
            "2136511328\n" +
            "3694931569\n" +
            "7463417111\n" +
            "1319128137\n" +
            "1359912421\n" +
            "3125421639\n" +
            "1293138521\n" +
            "2311944581"

    @Test
    internal fun task1Example1() {
        val input = example
            .lines()

        Assertions.assertThat(Day15().task1(input))
            .isEqualTo(40)
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day15.txt")
            .readLines()

        Assertions.assertThat(Day15().task1(input))
            .isEqualTo(609)
    }

    @Test
    internal fun task2Example1() {
        val input = example
            .lines()

        Assertions.assertThat(Day15().task2(input))
            .isEqualTo(315)
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day15.txt")
            .readLines()

        Assertions.assertThat(Day15().task2(input))
            .isEqualTo(2925)
    }
}