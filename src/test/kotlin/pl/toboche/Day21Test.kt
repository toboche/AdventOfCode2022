package pl.toboche

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day21Test {
    @Test
    internal fun task1Example() {
        assertEquals(
            135,
            Day21().task1(4, 8, 19)
        )
    }

    @Test
    internal fun task2Example() {
        assertEquals(
            336,
            Day21().task1(4, 8, 25)
        )
    }

    @Test
    internal fun task3Example() {
        assertEquals(
            739785,
            Day21().task1(4, 8, 1000)
        )
    }

    @Test
    internal fun task1() {
        assertEquals(
            739785,
            Day21().task1(4, 6, 1000)
        )
    }
}