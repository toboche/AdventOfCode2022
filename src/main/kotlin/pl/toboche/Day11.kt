package pl.toboche

class Day11 {

    data class Monkey(
        val items: List<Int>,
        val operation: Operation,
        val divisibleBy: Int,
        val trueResultNextMonkey: Int,
        val falseResultNextMonkey: Int,
        val inspections: Int,
    )

    sealed interface Operation {
        fun calculate(x: Int): Int

        companion object {
            fun parse(input: String): Operation {
                val beginning = input.substringAfter("Operation: new = old ").first()
                val after = input.substringAfter("Operation: new = old ").drop(2)
                return if (beginning == '+') {
                    Add(after.toInt())
                } else if (beginning == '*' && after == "old") {
                    Power
                } else if (beginning == '*') {
                    Multiply(after.toInt())
                } else {
                    throw Exception()
                }
            }
        }

        class Add(val op: Int) : Operation {
            override fun calculate(x: Int): Int {
                return x + op
            }
        }

        class Multiply(val op: Int) : Operation {
            override fun calculate(x: Int): Int {
                return x * op
            }
        }

        object Power : Operation {
            override fun calculate(x: Int): Int {
                return x * x
            }
        }
    }


    fun task1(input: List<String>): Int {
        return input.windowed(7, 7, true)
            .map { (monkeyString, startingItemsString, operationString, testString, trueString, falseString) ->
                Monkey(
                    startingItemsString.split(": ")[1].split(", ").map { it.toInt() },
                    Operation.parse(operationString),
                    testString.substringAfter("Test: divisible by ").toInt(),
                    trueString.substringAfter("If true: throw to monkey ").toInt(),
                    falseString.substringAfter("If false: throw to monkey ").toInt(),
                    0,
                )
            }.let {
                var monkeys = it.toMutableList()
                repeat(20) {
                    for (i in monkeys.indices) {
                        val monkey = monkeys[i]
                        val inspections = monkey.items.count()
                        monkey.items.forEach { item ->
                            val newValue = monkey.operation.calculate(item) / 3
                            if (newValue % monkey.divisibleBy == 0) {
                                monkeys[monkey.trueResultNextMonkey] =
                                    monkeys[monkey.trueResultNextMonkey].copy(items = monkeys[monkey.trueResultNextMonkey].items + newValue)
                            } else {
                                monkeys[monkey.falseResultNextMonkey] =
                                    monkeys[monkey.falseResultNextMonkey].copy(items = monkeys[monkey.falseResultNextMonkey].items + newValue)
                            }
                        }

                        val newMonkey = monkey.copy(
                            items = emptyList(), inspections = monkey.inspections + inspections
                        )
                        monkeys[i] = newMonkey
                    }
                }
                monkeys.sortedBy { -it.inspections }.let { it[0].inspections * it[1].inspections }
            }
    }
}

private operator fun <E> List<E>.component6(): E {
    return this[5]
}
