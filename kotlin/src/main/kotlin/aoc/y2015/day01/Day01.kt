package aoc.y2015.day01

import aoc.common.answer
import aoc.common.input
import aoc.common.verify

/**
 * Day 1
 * https://adventofcode.com/2015/day/1
 */

enum class Instruction(
    val char: Char,
    val change: Int,
) {
    UP('(', 1),
    DOWN(')', -1),
    STAY(' ', 0),
    ;

    companion object {
        fun from(char: Char): Instruction = entries.find { it.char == char } ?: STAY
    }
}

fun main() {
    val input = input(2015, 1)

    // Part 1
    val result = input.fold(0) { acc, c ->
        acc + when (c) {
            '(' -> 1
            ')' -> -1
            else -> 0
        }
    }

    val refactored = input
        .map { Instruction.from(it) }
        .sumOf { it.change }

    answer(2015, 1, 1, result)
    verify(2015, 1, 1, expected = result, actual = refactored)
}
