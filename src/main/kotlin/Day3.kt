package io.brudderbot

fun main() {
    val day3 = Day3()
    day3.solve()
}

class Day3 {
    private val input = readFileAsText("src/main/resources/Day3.txt")

    fun solve() {
        println("Part One: " + partOne())
        println("Part Two: " + partTwo())
    }

    private fun partOne(): Int {
        val data = input;
        val pattern = Regex("(mul\\((\\d*\\d),(\\d*\\d)\\))")
        val digitPattern = Regex("(\\d*\\d)")
        var result = 0
        pattern.findAll(data).forEach { mul ->
            val value = digitPattern.findAll(mul.value)
            val firstValue = value.first().value.toInt()
            val secondValue = value.last().value.toInt()

            result += firstValue*secondValue
        }
        return result
    }

    private fun partTwo(): Int {
        val data = input;
        val pattern = Regex("(mul\\((\\d*\\d),(\\d*\\d)\\))|(don't\\(\\))|(do\\(\\))")
        val digitPattern = Regex("(\\d*\\d)")
        var result = 0
        var lastCommandDo = true
        pattern.findAll(data).forEach { command ->
            if(command.value.contains("mul") && lastCommandDo){
                val value = digitPattern.findAll(command.value)
                val firstValue = value.first().value.toInt()
                val secondValue = value.last().value.toInt()

                result += firstValue*secondValue
            }else if (command.value.contains("don't")){lastCommandDo = false }else if (command.value.contains("do")){lastCommandDo = true }
        }
        return result
    }

}



