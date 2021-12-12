package pl.toboche

class Day12 {

    val graph = mutableMapOf<String, MutableSet<String>>()

    fun task1(input: List<String>): MutableList<List<String>> {
        input.map {
            val (start, end) = it.split('-')
            start to end
        }.forEach { (start, end) ->
            graph.compute(start) { _, value ->
                (value ?: mutableSetOf()).apply {
                    add(end)
                }
            }
            graph.compute(end) { _, value ->
                (value ?: mutableSetOf()).apply {
                    add(start)
                }
            }
        }

        val visitedFrom = mutableMapOf<String, MutableSet<String>>()
        val queue = mutableListOf<String>()
        queue.add("start")
        val pathList = mutableListOf<String>()
        val finalPaths = mutableListOf<List<String>>()
        printAllPaths("start", "end", visitedFrom, pathList, finalPaths, "")
        return finalPaths
    }

    private fun printAllPaths(
        start: String,
        end: String,
        visitedFrom: MutableMap<String, MutableSet<String>>,
        pathList: MutableList<String>,
        finalPaths: MutableList<List<String>>,
        source: String,
    ) {
        if (start == end) {
            finalPaths.add(pathList.map { it })
            return
        }

        visitedFrom.compute(start) { _, value ->
            (value ?: mutableSetOf()).apply { add(source) }
        }

        val nextToVisit = graph[start]!!.filter { it ->
            if (it.first().isLowerCase()) {
                visitedFrom[it] == null
            } else {
                !(visitedFrom[it]?.contains(start) ?: false)
            }
        }

        nextToVisit.forEach { next ->
            val localPathList = pathList.toMutableList().apply { add(next) }
            printAllPaths(next, end, visitedFrom.toMutableMap(), localPathList, finalPaths, source)
        }

        visitedFrom.compute(start) { _, value ->
            (value ?: mutableSetOf()).apply { remove(source) }
        }

    }
}