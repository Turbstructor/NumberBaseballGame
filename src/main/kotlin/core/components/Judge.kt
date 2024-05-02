package spartacodingclub.nbcamp.kotlinspring.assignment.numberBaseballGame.core.components

object Judge {
    private var strikes: Int = 0
    private var balls: Int = 0

    val isStrikeOut: Boolean
        get() = (strikes == 3)

    private fun clear() {
        strikes = 0; balls = 0
    }

    private fun generateDigitIndices(number: Int): IntArray {
        val result = IntArray(10) { -1 }
        var numberVar = number

        for (i in 2 downTo 0) {
            result[numberVar % 10] = i
            numberVar /= 10
        }

        return result
    }

    fun judge(source: Int, target: Int) {
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
    }

    override fun toString(): String = "Your guess makes... $strikes strike(s), $balls ball(s)"
}