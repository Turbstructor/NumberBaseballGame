package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame

import spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.NumberBaseballGameRunner

fun main() {
    val gameRunner = NumberBaseballGameRunner()
    var menu: Int

    println("Welcome to the Number Baseball Game!\n")
    while (true) {
        while (true) {
            try {
                println("1. Play a new game | 2. Show previous records | 3. Exit")
                print("Tell me what you want to do: ")

                menu = readln().toInt()
                if (menu in 1..3) break
            } catch (e: NumberFormatException) {
                print("Error: Invalid input: ${e.message}")
                println("Please try again with number within range [1, 3].\n")
            } catch (e: CharacterCodingException) {
                print("Error: Invalid input: ${e.message}")
                println("Please try again with number within range [1, 3].\n")
            } catch (e: RuntimeException) {
                print("Error: Invalid input: ${e.message}")
                println("Please try again with number within range [1, 3].\n")
            }
        }

        println()

        when (menu) {
            1 -> gameRunner.playGame()
            2 -> gameRunner.showRecords()
            3 -> break
        }

        println("\n${"-".repeat(64)}\n")
    }

    println("Shutting down...")
}