package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core

import spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components.*

class NumberBaseballGameRunner {
    private val gameRecord = GameRecord()

    fun playGame() {
        val player = Player()
        val opponent = Opponent()
        val judge = Judge()

        while (player.number != opponent.number) {
            player.makeGuess()

            gameRecord.countCurrentGame()
            if (judge.isStrikedOut(player.number, opponent.number)) {
                println("Strike-out! You've made it in ${gameRecord.attemptsCurrentGame} attempt(s)!\n")
                gameRecord.addRecord()
                break
            } else println("$judge\n")
        }
    }

    fun showRecords() {
        println(gameRecord)
    }
}