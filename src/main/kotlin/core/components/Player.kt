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

                if (isNumberValid) break
                else println("Error: Invalid input: number is not 3-digited nor all 3 digits are not unique!")
            } catch (e: NumberFormatException) {
                print("Error: Invalid input: ${e.message?.replaceFirstChar { it.lowercase() }}")
            } catch (e: CharacterCodingException) {
                print("Error: Invalid input: ${e.message}!")
            } catch (e: RuntimeException) {
                print("Error: Invalid input: ${e.message}!")
            } finally {
                if (isNumberValid) break
                println("Please try again with 3-digit number with all 3 digits unique.\n")
            }
        }
    }
}