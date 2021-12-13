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
                                x to foldValue - (y - foldValue)
                            } else {
                                x to y
                            }
                        } else {
                            if (x > foldValue) {
                                foldValue - (x - foldValue) to y
                            } else {
                                x to y
                            }
                        }
                    }.toSet()
                set = newSet
            }
        return set
            .size
    }

//    (set.groupBy { it.second }.map { ( key, value)-> key to value.map { it.first }.sorted() } as MutableList).sortedBy { it.first }.map {(_, list)->
//        (0..38).map { if(list.contains(it))'#' else '_' }.joinToString("")
//    }

}