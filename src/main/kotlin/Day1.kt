package io.brudderbot

import kotlin.math.abs


fun main() {
    val day1 = Day1()
    day1.solve()
}

class Day1 {
    private val input = readFileAsText("src/main/resources/Day1.txt")

    fun solve() {
        val lists = getLists()
        println("Part One: " + partOne(lists))
        println("Part Two: " + partTwo(lists))
    }

    private fun partOne(lists: Pair<List<Int>, List<Int>>): Int {
        var distance = 0
        for (i in 0 until lists.first.size) {
            distance += abs(lists.first[i] - lists.second[i])
        }
        return (distance)
    }

    private fun partTwo(lists: Pair<List<Int>, List<Int>>): Int {
        var score = 0;

        for (i in 0 until lists.first.size) {
            val item = lists.first[i]
            lists.second.filter { it == item }.forEach {
                score += item
            }
        }

        return(score)
    }

    private fun getLists(): Pair<List<Int>, List<Int>> {
        val firstList = mutableListOf<Int>()
        val lastList = mutableListOf<Int>()
        for (line in input.lines()) {
            firstList.add(line.split("   ").first().toInt())
            lastList.add(line.split("   ").last().toInt())
        }

        firstList.sort()
        lastList.sort()

        return Pair(firstList, lastList)
    }

}