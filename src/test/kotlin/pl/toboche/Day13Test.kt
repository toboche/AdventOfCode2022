package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day13Test {
    @Test
    fun task1ExampleParsing1() {
        assertEquals(
            listOf(emptyList<Int>()),
            Day13().mapToList("[]").first
        )
    }

    @Test
    fun task1ExampleParsing2() {
        assertEquals(
            listOf(listOf(1, 2, 3)),
            Day13().mapToList("[1,2,3]").first
        )
    }

    @Test
    fun task1ExampleParsing3() {
        assertEquals(
            listOf(listOf(11, 20, 33)),
            Day13().mapToList("[11,20,33]").first
        )
    }

    @Test
    fun task1Example() {
        val input = ("[1,1,3,1,1]\n" +
                "[1,1,5,1,1]\n" +
                "\n" +
                "[[1],[2,3,4]]\n" +
                "[[1],4]\n" +
                "\n" +
                "[9]\n" +
                "[[8,7,6]]\n" +
                "\n" +
                "[[4,4],4,4]\n" +
                "[[4,4],4,4,4]\n" +
                "\n" +
                "[7,7,7,7]\n" +
                "[7,7,7]\n" +
                "\n" +
                "[]\n" +
                "[3]\n" +
                "\n" +
                "[[[]]]\n" +
                "[[]]\n" +
                "\n" +
                "[1,[2,[3,[4,[5,6,7]]]],8,9]\n" +
                "[1,[2,[3,[4,[5,6,0]]]],8,9]")
            .lines()
        assertEquals(
            13,
            Day13().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/day13Task.txt")
            .readText()
            .lines()

        assertEquals(
            13,
            Day13().task1(input)
        )
    }

    @Test
    fun task2Example() {
        val input = ("[1,1,3,1,1]\n" +
                "[1,1,5,1,1]\n" +
                "\n" +
                "[[1],[2,3,4]]\n" +
                "[[1],4]\n" +
                "\n" +
                "[9]\n" +
                "[[8,7,6]]\n" +
                "\n" +
                "[[4,4],4,4]\n" +
                "[[4,4],4,4,4]\n" +
                "\n" +
                "[7,7,7,7]\n" +
                "[7,7,7]\n" +
                "\n" +
                "[]\n" +
                "[3]\n" +
                "\n" +
                "[[[]]]\n" +
                "[[]]\n" +
                "\n" +
                "[1,[2,[3,[4,[5,6,7]]]],8,9]\n" +
                "[1,[2,[3,[4,[5,6,0]]]],8,9]")
            .lines()
        assertEquals(
            140,
            Day13().task2(input)
        )
    }

    @Test
    fun task2() {
        val input = File("src/test/resources/day13Task.txt")
            .readText()
            .lines()

        assertEquals(
            13,
            Day13().task2(input)
        )
    }

}