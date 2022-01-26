package pl.toboche

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

    data class Dice(val lastValue: Int) {
        fun currentRoll(): Int = if (lastValue < 97) (3*lastValue) + 1 + 2 + 3
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