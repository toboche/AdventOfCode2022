package pl.toboche

class Day13 {
    fun task1(input: List<String>, singleFold: Boolean): Int {
        val empty = input.indexOfFirst { it.isEmpty() }

        val folds = input.filter { it.startsWith("fold along ") }.map {
            val axisS = "[xy]".toRegex().find(it)!!.groups[0]!!.value
            val valueS = it.substringAfter("=")
            axisS.first() to valueS.toInt()
        }
        val map = input.take(empty)
            .map { line ->
                val (x, y) = line.split(",")
                    .map { it.toInt() }
                x to y
            }
        var set = map.toSet()

        if (singleFold) {
            folds.take(1)
        } else {
            folds
        }
            .forEach { (foldAxis, foldValue) ->
                val newSet =
                    set.map { (x, y) ->
                        if (foldAxis == 'y') {
                            if (y > foldValue) {
                                x to (y - foldValue + 1)
                            } else {
                                x to y
                            }
                        } else {
                            if (x > foldValue) {
                                5 - (9 - 5)
                                foldValue - (x - foldValue) to y
                            } else {
                                x to y
                            }
                        }
                    }.toSet()
                set = newSet
            }
//            .fold(setOf<Pair<Int, Int>>()) { set, point ->
//                set + folds.fold(point) { (x, y), (foldAxis, foldValue) ->
//                }
//            }
        return set
            .size
    }

}