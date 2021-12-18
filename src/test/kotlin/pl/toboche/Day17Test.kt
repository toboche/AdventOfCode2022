package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day17Test {
    @Test
    internal fun task1Example() {
        val input = "target area: x=20..30, y=-10..-5"

        Assertions.assertThat(
            Day17().task1(input)).isEqualTo(45)
    }
}