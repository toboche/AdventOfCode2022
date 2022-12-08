package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day8Test {
    @Test
    fun task1Example() {
        val input = ("30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390")
            .lines()
        assertEquals(
            21,
            Day8().task1(input)
        )
    }

}