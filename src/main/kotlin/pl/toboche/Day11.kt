package pl.toboche

import java.math.BigInteger

class Day11 {

    data class Monkey(
        val items: List<BigInteger>,
        val operation: Operation,
        val divisibleBy: BigInteger,
        val trueResultNextMonkey: Int,
        val falseResultNextMonkey: Int,
        val inspections: Long,
    )

    sealed interface Operation {
        fun calculate(x: BigInteger, decreaseWorry: Boolean): BigInteger

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
            override fun calculate(x: BigInteger, decreaseWorry: Boolean): BigInteger {
                return x + op
            }
        }

        class Multiply(val op: BigInteger) : Operation {
            override fun calculate(x: BigInteger, decreaseWorry: Boolean): BigInteger {
                return x * op

            }
        }

        object Power : Operation {
            override fun calculate(x: BigInteger, decreaseWorry: Boolean): BigInteger {
                return x * x

            }
        }
    }

    fun task1(input: List<String>, count: Int, decreaseWorry: Boolean = true): Long {
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
                val monkeys = it.toMutableList()
                val lcm = it.map { it.divisibleBy }.fold(BigInteger.ONE) { acc, it -> acc * it }
                repeat(count) {
                    if (it % 1000 == 0) {
                        println(it)
                    }
                    for (i in monkeys.indices) {
                        val monkey = monkeys[i]
                        val inspections = monkey.items.count()
                        monkey.items.forEach { item ->
                            val newValue = monkey.operation.calculate(item, decreaseWorry)
                                .let {
                                    if (decreaseWorry) {
                                        it / 3.toBigInteger()
                                    } else {
                                        it % lcm
                                    }
                                }
                            if (newValue % monkey.divisibleBy == BigInteger.ZERO) {
                                monkeys[monkey.trueResultNextMonkey] =
                                    monkeys[monkey.trueResultNextMonkey].copy(items = monkeys[monkey.trueResultNextMonkey].items + newValue)
                            } else {
                                monkeys[monkey.falseResultNextMonkey] =
                                    monkeys[monkey.falseResultNextMonkey].copy(items = monkeys[monkey.falseResultNextMonkey].items + newValue)
                            }
                        }

                        val newMonkey = monkey.copy(
                            items = emptyList(), inspections = monkey.inspections + inspections.toLong()
                        )
                        monkeys[i] = newMonkey
                    }
                }
                monkeys.sortedBy { -it.inspections }.let { it[0].inspections.toLong() * it[1].inspections.toLong() }
            }
    }
}

private operator fun <E> List<E>.component6(): E {
    return this[5]
}
