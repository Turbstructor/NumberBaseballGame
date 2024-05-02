package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components

class Player {
    var number: Int = 0
        private set

    private val isNumberValid: Boolean
        get() = (number in 100..999 && number.toString().toCharArray().toSet().size == 3)

    fun makeGuess() {
        while (true) {
            try {
                print("Enter number of your guess: ")

                number = readln().toInt()
            } catch (e: NumberFormatException) {
                println("Error: Invalid input: cannot parse value into int ${e.message?.replaceFirstChar { it.lowercase() }}")
            } finally {
                if (isNumberValid) break
                println("Please try again with 3-digit number with all 3 digits unique.\n")
            }
        }
    }
}