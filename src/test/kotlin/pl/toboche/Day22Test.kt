package pl.toboche

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day22Test {
    @Test
    internal fun task1Example() {
        assertEquals(
            27,
            Day22().task1(
                "on x=10..12,y=10..12,z=10..12"
            )
        )
    }

}