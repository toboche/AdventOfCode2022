package pl.toboche

class Day7 {

    fun task1(input: List<String>): Int {
        val currentPathSize = mutableListOf<Int>()
        var sum = 0
        input.forEach { line ->
            if (line.startsWith("\$ cd") and !line.startsWith("\$ cd ..")) {
                val name = line.substringAfter("\$ cd ")
                currentPathSize.add(0)
            } else if (line.startsWith("\$ ls")) {

            } else if (line == "\$ cd ..") {
                val currentSize = currentPathSize.removeLast()
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
        return sum
    }
}