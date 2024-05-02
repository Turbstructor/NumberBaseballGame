package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame

import spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.NumberBaseballGameRunner

fun main() {
    var menu: Int = 0

    println("Welcome to the Number Baseball Game!\n")
    while (true) {
        while (true) {
            try {
                println("1. Play a new game | 2. Show previous records | 3. Exit")
                print("Tell me what you want to do: ")

                menu = readln().toInt()
            } catch (e: NumberFormatException) {
                println("Error: Invalid input: cannot parse value into int ${e.message?.replaceFirstChar { it.lowercase() }}")
            } finally {
                if (menu in 1..3) break
                println("Please try again with number within range [1, 3].\n")
            }
        }

        println()

        when (menu) {
            1 -> NumberBaseballGameRunner.playGame()
            2 -> NumberBaseballGameRunner.showRecords()
            3 -> break
        }

        println("\n${"-".repeat(64)}\n")
    }

    println("Shutting down...")
}