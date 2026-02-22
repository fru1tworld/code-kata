package aoc.y2015.day03

import aoc.common.answer
import aoc.common.input
import aoc.common.verify

/**
 * Day 3
 * https://adventofcode.com/2015/day/3
 */

data class House(
    val x: Int,
    val y: Int,
) {
    fun move(direction: Char): House =
        when (direction) {
            '^' -> copy(y = y + 1)
            'v' -> copy(y = y - 1)
            '<' -> copy(x = x - 1)
            '>' -> copy(x = x + 1)
            else -> this
        }
}

fun main() {
    val input = input(2015, 3)

    // Part 1
    val part1Original = HashSet<House>().also { visited ->
        var house = House(0, 0)
        input.forEach { char ->
            house = house.move(char)
            visited.add(house)
        }
    }.size

    val part1Refactored = input
        .runningFold(House(0, 0)) { house, dir -> house.move(dir) }
        .toSet()
        .size

    answer(2015, 3, 1, part1Original)
    verify(2015, 3, 1, expected = part1Original, actual = part1Refactored)

    // Part 2
    val (santaMoves, roboMoves) = input.withIndex()
        .partition { it.index % 2 == 0 }
        .let { (s, r) -> s.map { it.value } to r.map { it.value } }

    val part2Result = listOf(santaMoves, roboMoves)
        .flatMap { moves -> moves.runningFold(House(0, 0)) { h, d -> h.move(d) } }
        .toSet()
        .size

    answer(2015, 3, 2, part2Result)
}
