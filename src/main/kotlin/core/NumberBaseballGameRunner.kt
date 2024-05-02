package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core

import spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components.*

object NumberBaseballGameRunner {
    fun playGame() {
        GameRecord.initNewGame()
        val player = Player()
        val opponent = Opponent()

        do {
            player.makeGuess()
            GameRecord.logAttempt(player.number)

            Judge.judge(player.number, opponent.number)
            println("$Judge")

            if (Judge.isStrikeOut) {
                println("Strike-out! You've made it in ${GameRecord.attemptsCurrentGame.size} attempt(s)!")
                GameRecord.logCurrentGame()
            }
            println()
        } while (player.number != opponent.number)
    }

    fun showRecords() {
        println(GameRecord)
    }
}