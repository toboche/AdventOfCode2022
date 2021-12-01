package pl.toboche

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day1Test {
    @Test
    internal fun task1Example() {
        val input = ("199\n" +
                "200\n" +
                "208\n" +
                "210\n" +
                "200\n" +
                "207\n" +
                "240\n" +
                "269\n" +
                "260\n" +
                "263")
            .lines()
        Assertions.assertEquals(7,
            Day1().task1(input))
    }
}