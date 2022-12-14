package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day7Test {
    @Test
    fun task1Example() {
        val input = ("\$ cd /\n" +
                "\$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "\$ cd a\n" +
                "\$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "\$ cd e\n" +
                "\$ ls\n" +
                "584 i\n" +
                "\$ cd ..\n" +
                "\$ cd ..\n" +
                "\$ cd d\n" +
                "\$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k")
            .lines()
        assertEquals(
            95437,
            Day7().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/Day7Task1.txt")
            .readText()
            .lines()

        assertEquals(
            1086293,
            Day7().task1(input)
        )
    }

    @Test
    fun task2Example() {
        val input = ("\$ cd /\n" +
                "\$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "\$ cd a\n" +
                "\$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "\$ cd e\n" +
                "\$ ls\n" +
                "584 i\n" +
                "\$ cd ..\n" +
                "\$ cd ..\n" +
                "\$ cd d\n" +
                "\$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k")
            .lines()
        assertEquals(
            24933642,
            Day7().task1(input, true)
        )
    }

    @Test
    fun task2() {
        val input = File("src/test/resources/Day7Task1.txt")
            .readText()
            .lines()

        //16624734 - zla
        assertEquals(
            1086293,
            Day7().task1(input, true)
        )
    }
}