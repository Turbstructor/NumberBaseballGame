package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components

class GameRecord {
    var attemptsCurrentGame: MutableList<Int> = mutableListOf()
        private set
    private val attempts: MutableList<MutableList<Int>> = mutableListOf()

    fun logAttempt(number: Int) {
        attemptsCurrentGame.add(number)
    }

    fun initNewGame() {
        attemptsCurrentGame = mutableListOf()
    }

    fun logCurrentGame() {
        attempts.add(attemptsCurrentGame);
    }

    override fun toString(): String {
        var message = "Querying game records..."

        when (attempts.size) {
            0 -> message += " None found."
            else -> attempts.forEachIndexed { index, guesses ->
                message += "\nGame #${index + 1}: ${guesses.size} guess(es)\n" +
                        "> For ${guesses.last()}: (${guesses.joinToString(" -> ")})"
            }
        }

        return message
    }
}