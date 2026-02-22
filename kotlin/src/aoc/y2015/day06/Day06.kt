package aoc.y2015.day06

import aoc.common.answer
import aoc.common.inputLinesNotBlank
import java.util.BitSet

fun main() {
    val instructions = inputLinesNotBlank(2015, 6).map { InstructionParser.parse(it) }

    val part1 = solvePart1(instructions)
    answer(2015, 6, 1, part1)

    val part2 = solvePart2(instructions)
    answer(2015, 6, 2, part2)
}

private fun solvePart1(instructions: List<Instruction>): Int {
    val grid = Array(1000) { BitSet(1000) }

    instructions.forEach { (action, region) ->
        for (y in region.from.y..region.to.y) {
            when (action) {
                Action.TurnOn -> grid[y].set(region.from.x, region.to.x + 1)
                Action.TurnOff -> grid[y].clear(region.from.x, region.to.x + 1)
                Action.Toggle -> grid[y].flip(region.from.x, region.to.x + 1)
            }
        }
    }

    return grid.sumOf { it.cardinality() }
}

private fun solvePart2(instructions: List<Instruction>): Int {
    val grid = Array(1000) { IntArray(1000) }

    instructions.forEach { (action, region) ->
        for (y in region.from.y..region.to.y) {
            for (x in region.from.x..region.to.x) {
                grid[y][x] = when (action) {
                    Action.TurnOn -> grid[y][x] + 1
                    Action.TurnOff -> (grid[y][x] - 1).coerceAtLeast(0)
                    Action.Toggle -> grid[y][x] + 2
                }
            }
        }
    }

    return grid.sumOf { it.sum() }
}
