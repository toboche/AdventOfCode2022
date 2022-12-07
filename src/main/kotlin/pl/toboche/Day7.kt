package pl.toboche

class Day7 {

    fun task1(input: List<String>, findMin: Boolean = false): Int {
        val tree = mutableMapOf<String, Int>()
        val currentPath = mutableListOf<String>()
        val currentPathSize = mutableListOf<Int>()
        var sum = 0
        input.forEach { line ->
            if (line.startsWith("\$ cd") and !line.startsWith("\$ cd ..")) {
                val name = line.substringAfter("\$ cd ")
                currentPath.add(name)
                currentPathSize.add(0)
            } else if (line.startsWith("\$ ls")) {

            } else if (line == "\$ cd ..") {
                val currentDirName = currentPath.removeLast()
                val currentSize = currentPathSize.removeLast()
                tree[currentDirName] = currentSize
                if (currentSize <= 100000)
                    sum += currentSize
                currentPathSize.add(currentPathSize.removeLast() + currentSize)
            } else if (line.startsWith("dir")) {
                //do nothing
            } else {
                val currentDirSize = line.split(" ").first().toInt()
                currentPathSize.add(currentPathSize.removeLast() + currentDirSize)
            }
        }
        while (currentPath.isNotEmpty()) {
            val currentDirName = currentPath.removeLast()
            val currentSize = currentPathSize.removeLast()
            tree[currentDirName] = currentSize
            if (currentSize <= 100000)
                sum += currentSize
            if (currentPathSize.isNotEmpty()) {
                currentPathSize.add(currentPathSize.removeLast() + currentSize)
            }
        }
        if (findMin) {
            val rootSize = tree["/"]!!
            val toRemove =  rootSize - 30000000
            val sortedBy = tree.entries.sortedBy { it.value }
            val toReturn = sortedBy.first { it.value >= toRemove }.value
            return toReturn
        } else {
            return sum
        }
    }
}