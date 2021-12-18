package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day18Test {
    @Test
    internal fun task1Example() {
        val input = ("[1,2]\n" +
                "[[3,4],5]").lines()

        Assertions.assertThat(
            Day18().task1(input)).isEqualTo(45)
    }

    @Test
    internal fun parse1() {
        val input = "[1,2]"

        Assertions.assertThat(
            Day18.Number.parse(input)).isEqualTo(
            Day18.PairNumber(Day18.Regular(1), Day18.Regular(2))
        )
    }

    @Test
    internal fun parse2() {
        val input = "[[1,2],3]"

        Assertions.assertThat(
            Day18.Number.parse(input)).isEqualTo(
            Day18.PairNumber(Day18.PairNumber(Day18.Regular(1), Day18.Regular(2)), Day18.Regular(3))
        )
    }

    @Test
    internal fun parse3() {
        val input = "[9,[8,7]]"

        Assertions.assertThat(
            Day18.Number.parse(input)).isEqualTo(
            Day18.PairNumber(Day18.Regular(9), Day18.PairNumber(Day18.Regular(8), Day18.Regular(7)))
        )
    }

    @Test
    internal fun parse4() {
        val input = "[[[[1,2],[3,4]],[[5,6],[7,8]]],9]"

        Assertions.assertThat(
            Day18.Number.parse(input)).isEqualTo(
            Day18.PairNumber(
                Day18.PairNumber(
                    Day18.PairNumber(
                        Day18.PairNumber(
                            Day18.Regular(1),
                            Day18.Regular(2)
                        ),
                        Day18.PairNumber(
                            Day18.Regular(3),
                            Day18.Regular(4)
                        )
                    ),
                    Day18.PairNumber(
                        Day18.PairNumber(
                            Day18.Regular(5),
                            Day18.Regular(6)
                        ),
                        Day18.PairNumber(
                            Day18.Regular(7),
                            Day18.Regular(8)
                        )
                    )
                ),
                Day18.Regular(9)
            )
        )
    }
}