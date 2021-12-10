package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day10Test {
    @Test
    internal fun task1Example() {
        val input = (
                "[]\n" +
                        "([])\n" +
                        "{()()()}\n" +
                        "<([{}])>\n" +
                        "[<>({}){}[([])<>]]\n" +
                        "(((((((((())))))))))\n"
                )
            .lines()

        assertEquals(0,
            Day10().task1(input))
    }

    @Test
    internal fun task1Example2() {
        val input = (
                "[({(<(())[]>[[{[]{<()<>>\n" +
                        "[(()[<>])]({[<{<<[]>>(\n" +
                        "{([(<{}[<>[]}>{[]{[(<()>\n" +
                        "(((({<>}<{<{<>}{[]{[]{}\n" +
                        "[[<[([]))<([[{}[[()]]]\n" +
                        "[{[{({}]{}}([{[{{{}}([]\n" +
                        "{<[[]]>}<{[{[{[]{()[[[]\n" +
                        "[<(<(<(<{}))><([]([]()\n" +
                        "<{([([[(<>()){}]>(<<{{\n" +
                        "<{([{{}}[<[[[<>{}]]]>[]]"
                )
            .lines()

        assertEquals(26397,
            Day10().task1(input))
    }

}