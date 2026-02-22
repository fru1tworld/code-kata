package aoc.y2015.day02

import aoc.common.answer
import aoc.common.inputLinesNotBlank
import aoc.common.verify

/**
 * Day 2
 * https://adventofcode.com/2015/day/2
 */
data class Box(
    val l: Int,
    val w: Int,
    val h: Int,
) {
    private val sortedDims = listOf(l, w, h).sorted()
    private val s1 = sortedDims[0]
    private val s2 = sortedDims[1]

    val totalPaper: Int
        get() = (2 * l * w) + (2 * w * h) + (2 * h * l) + (s1 * s2)

    val totalRibbon: Int
        get() = (2 * (s1 + s2)) + (l * w * h)

    companion object {
        fun from(line: String): Box {
            val dims = line.split('x').map { it.toInt() }
            return Box(dims[0], dims[1], dims[2])
        }
    }
}

fun main() {
    val input = inputLinesNotBlank(2015, 2)
    val boxes = input.map(Box::from)

    // Part 1
    val part1Result = input.sumOf { line ->
        val (a, b, c) = line.split("x").map { it.toInt() }.sorted()
        2 * a * b + 2 * b * c + 2 * a * c + a * b
    }

    val part1Refactored = boxes.sumOf { it.totalPaper }

    answer(2015, 2, 1, part1Result)
    verify(2015, 2, 1, expected = part1Result, actual = part1Refactored)

    // Part 2
    val part2Result = input.sumOf { line ->
        val (a, b, c) = line.split("x").map { it.toInt() }.sorted()
        2 * (a + b) + a * b * c
    }

    val part2Refactored = boxes.sumOf { it.totalRibbon }

    answer(2015, 2, 2, part2Result)
    verify(2015, 2, 2, expected = part2Result, actual = part2Refactored)
}
