class Day8 {
    fun task1(input: List<String>): Int {
        return input.sumOf {
            it.split("|")[1]
                .split(" ")
                .count { listOf(2, 4, 3, 7).contains(it.trim().length) }
        }
    }

    val encodings = mapOf<Set<Char>, Int>(
        setOf('a', 'b', 'c', 'e', 'f', 'g') to 0,
        setOf('c', 'f') to 1,
        setOf('a', 'c', 'd', 'e', 'g') to 2,
        setOf('a', 'c', 'd', 'f', 'g') to 3,
        setOf('b', 'c', 'd', 'f') to 4,
        setOf('a', 'b', 'd', 'f', 'g') to 5,
        setOf('a', 'b', 'd', 'e', 'f', 'g') to 6,
        setOf('a', 'c', 'f') to 7,
        setOf('a', 'b', 'c', 'd', 'e', 'f', 'g') to 8,
        setOf('a', 'b', 'c', 'd', 'f', 'g') to 9,
    )

    fun task2(input: List<String>): Int {
        return input.sumOf {
            val split = it.split("|")
            val values = split[0]
                .split(" ")

            val cf = values.first { it.length == 2 }.toSet()
            val acf = values.first { it.length == 3 }.toSet()
            val a = acf - cf
            val all = values.first { it.length == 7 }.toSet()
            val allSixSegment = values.filter { it.length == 6 }.toSet()
            val c = cf.minus(allSixSegment.fold(all) { acc, sevenSegment -> acc.intersect(sevenSegment.toSet()) })
            val f = cf - c
            val bd = values.first { it.length == 4 }.toSet() - cf
            val g =
                (allSixSegment.fold(all) { acc, sevenSegment -> acc.intersect(sevenSegment.toSet()) }) - a - c - bd - f
            val b = allSixSegment.fold(all) { acc, sevenSegment -> acc.intersect(sevenSegment.toSet()) } - g - f - a
            val d = bd - b
            val e = all - a - b - c - d - f - g
            val mapping = mapOf(
                a.first() to 'a',
                b.first() to 'b',
                c.first() to 'c',
                d.first() to 'd',
                e.first() to 'e',
                f.first() to 'f',
                g.first() to 'g',
            )

            split[1].split(" ")
                .filter { it.isNotBlank() }.joinToString("") {
                    encodings[it.map { mapping[it] }
                        .toSet()]!!.toString()
                }
                .toInt()
        }
    }

}