package pl.toboche

import java.math.BigInteger

class Day11 {

    data class Monkey(
        val items: List<BigInteger>,
        val operation: Operation,
        val divisibleBy: BigInteger,
        val trueResultNextMonkey: Int,
        val falseResultNextMonkey: Int,
        val inspections: Int,
    )

    sealed interface Operation {
        fun calculate(x: BigInteger): BigInteger

        companion object {
            fun parse(input: String): Operation {
                val beginning = input.substringAfter("Operation: new = old ").first()
                val after = input.substringAfter("Operation: new = old ").drop(2)
                return if (beginning == '+') {
                    Add(after.toBigInteger())
                } else if (beginning == '*' && after == "old") {
                    Power
                } else if (beginning == '*') {
                    Multiply(after.toBigInteger())
                } else {
                    throw Exception()
                }
            }
        }

        class Add(val op: BigInteger) : Operation {
            override fun calculate(x: BigInteger): BigInteger {
                return x + op
            }
        }

        class Multiply(val op: BigInteger) : Operation {
            override fun calculate(x: BigInteger): BigInteger {
                return x * op
            }
        }

        object Power : Operation {
            override fun calculate(x: BigInteger): BigInteger {
                return x * x
            }
        }
    }


    fun task1(input: List<String>, count: Int): Int {
        return input.windowed(7, 7, true)
            .map { (monkeyString, startingItemsString, operationString, testString, trueString, falseString) ->
                Monkey(
                    startingItemsString.split(": ")[1].split(", ").map { it.toBigInteger() },
                    Operation.parse(operationString),
                    testString.substringAfter("Test: divisible by ").toBigInteger(),
                    trueString.substringAfter("If true: throw to monkey ").toInt(),
                    falseString.substringAfter("If false: throw to monkey ").toInt(),
                    0,
                )
            }.let {
                var monkeys = it.toMutableList()
                repeat(count) {
                    for (i in monkeys.indices) {
                        val monkey = monkeys[i]
                        val inspections = monkey.items.count()
                        monkey.items.forEach { item ->
                            val newValue = monkey.operation.calculate(item) / 3.toBigInteger()
                            if (newValue % monkey.divisibleBy == BigInteger.ZERO) {
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
