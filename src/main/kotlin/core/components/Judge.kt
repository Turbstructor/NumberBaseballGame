package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components

class Judge {
    private var strikes: Int = 0
    private var balls: Int = 0

    private fun clear() {
        strikes = 0; balls = 0
    }

    private fun generateDigitIndices(number: Int): IntArray {
        val result = IntArray(10) { -1 }
        var numberVar = number

        for (i in 2 downTo 0) {
            result[numberVar % 10] = when (result[numberVar % 10]) {
                -1 -> i
                else -> throw IllegalArgumentException("Number does not have 3 unique digits")
            }

            numberVar /= 10
        }

        return result
    }

    fun isStrikedOut(source: Int, target: Int): Boolean {
        this.clear()

        val sourceIndices = generateDigitIndices(source)
        val targetIndices = generateDigitIndices(target)


        for (i in sourceIndices.indices) {
            when {
                sourceIndices[i] == -1 || targetIndices[i] == -1 -> continue
                sourceIndices[i] == targetIndices[i] -> strikes += 1
                else -> balls += 1
            }
        }

        return (strikes == 3)
    }

    override fun toString(): String = "Your guess makes... $strikes strike(s), $balls ball(s)"
}