package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day12Test {
    @Test
    internal fun task1Example1() {
        val input = ("start-A\n" +
                "start-b\n" +
                "A-c\n" +
                "A-b\n" +
                "b-d\n" +
                "A-end\n" +
                "b-end")
            .lines()

        Assertions.assertThat(Day12().task1(input)
            .map { "start," + it.joinToString(",") }
        ).containsAll(
            ("start,A,b,A,c,A,end\n" +
                    "start,A,b,A,end\n" +
                    "start,A,b,end\n" +
                    "start,A,c,A,b,A,end\n" +
                    "start,A,c,A,b,end\n" +
                    "start,A,c,A,end\n" +
                    "start,A,end\n" +
                    "start,b,A,c,A,end\n" +
                    "start,b,A,end\n" +
                    "start,b,end").lines(),
        )
    }

    @Test
    internal fun task1Example2() {
        val input = ("dc-end\n" +
                "HN-start\n" +
                "start-kj\n" +
                "dc-start\n" +
                "dc-HN\n" +
                "LN-dc\n" +
                "HN-end\n" +
                "kj-sa\n" +
                "kj-HN\n" +
                "kj-dc")
            .lines()

        Assertions.assertThat(Day12().task1(input)
            .map { "start," + it.joinToString(",") }
        ).hasSize(19)
    }

    @Test
    internal fun task1Example3() {
        val input = ("fs-end\n" +
                "he-DX\n" +
                "fs-he\n" +
                "start-DX\n" +
                "pj-DX\n" +
                "end-zg\n" +
                "zg-sl\n" +
                "zg-pj\n" +
                "pj-he\n" +
                "RW-he\n" +
                "fs-DX\n" +
                "pj-RW\n" +
                "zg-RW\n" +
                "start-pj\n" +
                "he-WI\n" +
                "zg-he\n" +
                "pj-fs\n" +
                "start-RW")
            .lines()

        Assertions.assertThat(Day12().task1(input)
            .map { "start," + it.joinToString(",") }
        ).hasSize(226)
    }

}