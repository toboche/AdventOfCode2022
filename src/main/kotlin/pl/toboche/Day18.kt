package pl.toboche

class Day18 {
    sealed class Number(

    ) {
        companion object {
            fun parse(str: String): Number {
                val valueStack = mutableListOf<Number>()
                val operatorStack = mutableListOf<Char>()
                str.forEach {
                    when (it) {
                        '[', ',' -> operatorStack.add(it)
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> valueStack.add(Regular(it.digitToInt()))
                        ']' -> {
                            val right = valueStack.removeLast()
                            val left = valueStack.removeLast()

                            valueStack.add(PairNumber(left, right))
                        }
                    }
                }
                return valueStack.first()
            }
        }
    }

    data class Regular(val value: Int) : Number()

    data class PairNumber(val left: Number, val right: Number) : Number()

    fun task1(input: List<String>): Any {
        input.map {
            Number.parse(it)
        }
        return -1
    }

}