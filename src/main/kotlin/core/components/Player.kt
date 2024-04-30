package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components

class Player {
    var number: Int = 0
        private set

    private val isNumberValid: Boolean
        get() = (number.toString().toCharArray().toSet().size == 3)

    fun makeGuess() {
        while (true) {
            try {
                print("Enter number of your guess: ")
                number = readln().toInt()

                if (isNumberValid) break
                else {
                    println("Error: Invalid input: 3 digits are not unique!")
                    println("Please try again with 3-digit number with all 3 digits unique.\n")
                }
            } catch (e: NumberFormatException) {
                print("Error: Invalid input: ${e.message}!")
                println("Please try again with 3-digit number with all 3 digits unique.\n")
            } catch (e: CharacterCodingException) {
                print("Error: Invalid input: ${e.message}!")
                println("Please try again with 3-digit number with all 3 digits unique.\n")
            } catch (e: RuntimeException) {
                print("Error: Invalid input: ${e.message}!")
                println("Please try again with 3-digit number with all 3 digits unique.\n")
            }
        }
    }
}