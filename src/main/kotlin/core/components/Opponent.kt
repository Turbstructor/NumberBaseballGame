package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components

import kotlin.random.Random

class Opponent {
    var number: Int = generateBaseballNumber()
        private set

    private fun generateBaseballNumber(): Int {
        var baseballNumber: Int
        do {
            baseballNumber = Random.nextInt(100, 1000)
        } while (baseballNumber.toString().toCharArray().toSet().size != 3)

        return baseballNumber
    }
}
