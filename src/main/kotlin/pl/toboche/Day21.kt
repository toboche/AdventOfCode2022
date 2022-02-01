package pl.toboche

import java.lang.Long.max
import kotlin.math.min

class Day21 {
    fun task1(playerOneStart: Int, playerTwoStart: Int, winLimit: Int): Int {
        var playerOne = Player(0, playerOneStart)
        var playerTwo = Player(0, playerTwoStart)
        var dice = Dice(0)
        var playerOneTurn = true
        var counter = 0
        while (playerOne.points < winLimit && playerTwo.points < winLimit) {
            counter += 3
            val diceValue = dice.currentRoll()
            dice = Dice(dice.maxValue())
            if (playerOneTurn) {
                playerOne = playerOne.move(diceValue)
            } else {
                playerTwo = playerTwo.move(diceValue)
            }
            playerOneTurn = !playerOneTurn
        }
        return counter * min(playerOne.points, playerTwo.points)
    }

    //can be optimised to get occurrences, but won't change much here
    private val threeDiceThrowCombinations =
        (1..3)
            .flatMap { x1 -> (1..3).map { x1 + it } }
            .flatMap { x1tox2 -> (1..3).map { x1tox2 + it } }

    fun task2(playerOneStart: Int, playerTwoStart: Int, winLimit: Int): Long {
        var playerOneWins = 0L
        var playerTwoWins = 0L

        val initialUniverse = UniverseState(
            playerOneStart,
            0,
            playerTwoStart,
            0
        )
        var universesCount = mutableMapOf(initialUniverse to 1L)
        var playerOneTurn = true
        while (universesCount.isNotEmpty()) {

            //for each possible dice result 1,2,3
            //map current universe to the next universe state
            universesCount = threeDiceThrowCombinations.map { diceRollsResultSum ->
                universesCount.map { currentUniverse ->
                    val oldState = currentUniverse.key
                    calculateNewState(
                        playerOneTurn,
                        oldState,
                        diceRollsResultSum,
                        currentUniverse
                    )
                }.toMap()
            }.fold(
                mutableMapOf()
            ) { acc, map ->
                map.entries.forEach { entry ->
                    acc.compute(entry.key) { key, value ->
                        (value ?: 0) + entry.value
                    }
                }
                acc
            }
            playerOneWins += universesCount.filter { it.key.playerOnePoints >= winLimit }.values.sum()
            playerTwoWins += universesCount.filter { it.key.playerTwoPoints >= winLimit }.values.sum()
            universesCount =
                universesCount.filterNot { it.key.playerOnePoints >= winLimit || it.key.playerTwoPoints >= winLimit }
                    .toMutableMap()
            playerOneTurn = !playerOneTurn
        }
        return max(playerOneWins, playerTwoWins)
    }

    private fun calculateNewState(
        playerOneTurn: Boolean,
        oldState: UniverseState,
        diceRollsResultSum: Int,
        currentUniverse: Map.Entry<UniverseState, Long>
    ): Pair<UniverseState, Long> {
        val (position, points) = if (playerOneTurn) {
            oldState.playerOnePosition to oldState.playerOnePoints
        } else {
            oldState.playerTwoPosition to oldState.playerTwoPoints
        }

        val newPosition = (position + diceRollsResultSum) % 10
        val newPoints = points + if (newPosition == 0) 10 else newPosition

        val newState = if (playerOneTurn) {
            oldState.copy(
                playerOnePoints = newPoints,
                playerOnePosition = newPosition
            )
        } else {
            oldState.copy(
                playerTwoPoints = newPoints,
                playerTwoPosition = newPosition
            )
        }

        val value = currentUniverse.value
        return newState to value
    }

    data class UniverseState(
        val playerOnePosition: Int,
        val playerOnePoints: Int,
        val playerTwoPosition: Int,
        val playerTwoPoints: Int,
    )

    data class Dice(val lastValue: Int) {
        fun currentRoll(): Int = if (lastValue < 97) (3 * lastValue) + 1 + 2 + 3
        else if (lastValue == 97) 8 + 9 + 0
        else if (lastValue == 98) 9 + 0 + 1
        else /*if(lastValue == 99)*/ 0 + 1 + 2

        fun maxValue(): Int = if (lastValue < 97) lastValue + 3
        else if (lastValue == 97) 0
        else if (lastValue == 98) 1
        else /*if(lastValue == 99)*/ 2
    }

    data class Player(val points: Int, val position: Int) {
        fun move(byValue: Int): Player {
            val newPosition = (position + byValue) % 10
            return Player(
                points = points + if (newPosition == 0) 10 else newPosition,
                position = newPosition,
            )
        }
    }

}