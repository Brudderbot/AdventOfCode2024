package io.brudderbot

import kotlin.math.abs

fun main() {
    val day2 = Day2()
    day2.solve()
}

class Day2 {
    private val input = readFileAsText("src/main/resources/Day2.txt")

    fun solve() {
        val list = getList()

        println("Part One: " + partOne(list))
        println("Part Two: " + partTwo(list))
    }


    private fun getList(): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        for (line in input.lines()) {
            list.add(line.split(" ").map { it.toInt() })
        }
        return (list)
    }

    private val safeReports = mutableListOf<List<Int>>()

    private fun partOne(list: List<List<Int>>): Int {
        list.forEach { report ->
            if (checkReport(report)) safeReports.add(report)
        }

        return (safeReports.size)
    }

    private fun partTwo(list: List<List<Int>>): Int {
        val badReports = list.filter { !safeReports.contains(it) }
        badReports.forEach{ report ->
            checkBadReport(report)
        }

        return(safeReports.size)

        }

    private fun checkBadReport(report: List<Int>) {
        for (i in report.indices) {
            val mutableList = report.toMutableList()
            mutableList.removeAt(i)

            if (checkReport(mutableList)) {
                safeReports.add(mutableList)
                break
            }
        }
    }

}

    private fun checkReport(report: List<Int>): Boolean {
        val decreasing: Boolean = report[0] > report[1]

        for (i in report.indices) {
            if (i + 1 < report.size){
                val numFirst = report[i]
                val numSecond = report[i+1]

                if (numFirst > numSecond && !decreasing) { return(false) }
                if (numFirst < numSecond && decreasing) { return(false) }
                if (numFirst == numSecond) { return(false) }
                if (3 < abs(numFirst - numSecond)){ return(false) }
            }
        }
        return true
    }



