package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components

class GameRecord {
    var attemptsCurrentGame: Int = 0
        private set
    private val attempts: MutableList<Int> = mutableListOf()

    fun countCurrentGame() {
        attemptsCurrentGame += 1
    }

    private fun clear() {
        attemptsCurrentGame = 0
    }

    fun addRecord() {
        attempts.add(attemptsCurrentGame); clear()
    }

    override fun toString(): String {
        var message = "Querying game records..."

        when (attempts.size) {
            0 -> message += " None found."
            else -> attempts.forEachIndexed { index, guesses ->
                message += "\nGame #$index: $guesses guess(es)"
            }
        }

        return message
    }
}