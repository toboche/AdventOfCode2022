package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class Day14Test {
    private val example = "NNCB\n" +
            "\n" +
            "CH -> B\n" +
            "HH -> N\n" +
            "CB -> H\n" +
            "NH -> C\n" +
            "HB -> C\n" +
            "HC -> B\n" +
            "HN -> C\n" +
            "NN -> C\n" +
            "BH -> H\n" +
            "NC -> B\n" +
            "NB -> B\n" +
            "BN -> B\n" +
            "BB -> N\n" +
            "BC -> B\n" +
            "CC -> N\n" +
            "CN -> C"

    @Test
    internal fun task1Example1() {
        val input = example
            .lines()

        Assertions.assertThat(Day14().task1String(input))
            .isEqualTo(1588)
    }

    @Test
    internal fun task1Example2() {
        val input = example
            .lines()

        Assertions.assertThat(Day14().task1String(input, steps = 1))
            .isEqualTo(1)
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day14.txt")
            .readLines()

        Assertions.assertThat(Day14().task1String(input, steps = 10))
            .isEqualTo(1)
    }
}