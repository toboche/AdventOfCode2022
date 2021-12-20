package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class Day20Test {
    @Test
    internal fun task1Example() {
        val input = File("src/test/resources/day20Example.txt")
            .readLines()

        Assertions.assertThat(
            Day20().task1(input, 2)).isEqualTo(35)
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day20.txt")
            .readLines()

        Assertions.assertThat(
            Day20().task1(input, 2)).isEqualTo(5479)
    }

    @Test
    internal fun task2Example() {
        val input = File("src/test/resources/day20Example.txt")
            .readLines()

        Assertions.assertThat(
            Day20().task1(input, 50)).isEqualTo(3351)
    }


    @Test
    internal fun task2() {
        val input = File("src/test/resources/day20.txt")
            .readLines()

        Assertions.assertThat(
            Day20().task1(input, 50)).isEqualTo(19012)
    }
}