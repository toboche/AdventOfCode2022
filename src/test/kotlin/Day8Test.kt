import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day8Test {
    @Test
    internal fun task1Example() {
        val input = File("src/test/resources/day8Example1.txt")
            .readLines()

        assertEquals(26,
            Day8().task1(input))
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day8Task1.txt")
            .readLines()

        assertEquals(26,
            Day8().task1(input))
    }
}