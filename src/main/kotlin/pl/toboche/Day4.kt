package pl.toboche

class Day4 {
    fun task1(input: List<String>): Int {
        val numbers = parseRandomNumbers(input)

        val (boardsCount, checked, boards) = parseBoards(input)

        var winningBoard = -1
        val winningNumber = numbers.first { number ->
            boards.forEachIndexed { boardIndex, board ->
                board.forEachIndexed { boardLineIndex, boardLine ->
                    for (index in boardLine.indices) {
                        if (boardLine[index] == number) {
                            checked[boardIndex][boardLineIndex][index] = true
                            if (wholeRowOrColumnChecked(checked[boardIndex],
                                    boardLineIndex,
                                    index)
                            ) {
                                winningBoard = boardIndex
                                return@first true
                            }
                        }
                    }
                }
            }
            false
        }

        return calculateBoardSum(boards, winningBoard, checked, winningNumber)
    }

    private fun wholeRowOrColumnChecked(checked: Array<BooleanArray>, boardLineIndex: Int, index: Int): Boolean =
        (0..4).all {
            checked[it][index]
        }
                ||
                (0..4).all {
                    checked[boardLineIndex][it]
                }

    fun task2(input: List<String>): Int {
        val numbers = parseRandomNumbers(input)

        val (boardsCount, checked, boards) = parseBoards(input)

        val boardsWinning = BooleanArray(boardsCount)
        numbers.forEach { number ->
            boards.forEachIndexed { boardIndex, board ->
                board.forEachIndexed { boardLineIndex, boardLine ->
                    for (index in boardLine.indices) {
                        if (boardLine[index] == number) {
                            checked[boardIndex][boardLineIndex][index] = true
                            if (wholeRowOrColumnChecked(checked[boardIndex],
                                    boardLineIndex,
                                    index)
                            ) {
                                boardsWinning[boardIndex] = true
                                if (boardsWinning.all { it }) {
                                    return calculateBoardSum(boards, boardIndex, checked, number)
                                }
                            }
                        }
                    }
                }
            }
        }

        return -1
    }

    private fun parseRandomNumbers(input: List<String>): List<Int> {
        val numbers = input[0]
            .split(",")
            .map { it.toInt() }
        return numbers
    }

    private fun parseBoards(input: List<String>): Triple<Int, Array<Array<BooleanArray>>, List<Array<IntArray>>> {
        val boardsCount = input.size / 6
        val checked = Array(boardsCount) { Array(5) { BooleanArray(5) } }

        val boards = (0 until boardsCount).map { boardNumber ->
            val boardStart = boardNumber * 6 + 1
            (boardStart + 1..boardStart + 5).map { boardLine ->
                input[boardLine]
                    .split(" ")
                    .filterNot { it.isEmpty() }
                    .map { it.toInt() }
                    .toIntArray()
            }.toTypedArray()
        }
        return Triple(boardsCount, checked, boards)
    }

    private fun calculateBoardSum(
        boards: List<Array<IntArray>>,
        winningBoard: Int,
        checked: Array<Array<BooleanArray>>,
        winningNumber: Int,
    ): Int {
        val boardSum = boards[winningBoard].withIndex().sumOf { (lineIndex, boardLine) ->
            boardLine.withIndex()
                .filter { (index, _) -> !checked[winningBoard][lineIndex][index] }
                .sumOf { (_, value) -> value }
        }

        return boardSum * winningNumber
    }

}