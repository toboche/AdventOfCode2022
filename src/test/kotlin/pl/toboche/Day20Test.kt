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
            Day20().task1(input)).isEqualTo(35)
    }
}