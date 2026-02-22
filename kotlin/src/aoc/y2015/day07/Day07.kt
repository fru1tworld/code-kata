package aoc.y2015.day07

import aoc.common.answer
import aoc.common.inputLinesNotBlank

/**
 * Day 7
 * https://adventofcode.com/2015/day/7
 */

fun main() {
    val input = inputLinesNotBlank(2015, 7)
    val instructions = input.map { InstructionParser.parse(it) }
    val graph = instructions.associateBy { it.destination }

    val cache = mutableMapOf<String, UShort>()

    fun solve(wire: String): UShort {
        wire.toUShortOrNull()?.let { return it }
        cache[wire]?.let { return it }

        val instruction = graph[wire] ?: error("Unknown wire: $wire")

        val result: UShort = when (instruction.command) {
            Command.ASSIGN -> solve(instruction.inputs[0])
            Command.NOT -> solve(instruction.inputs[0]).inv()
            Command.AND -> (solve(instruction.inputs[0]) and solve(instruction.inputs[1]))
            Command.OR -> (solve(instruction.inputs[0]) or solve(instruction.inputs[1]))
            Command.LSHIFT -> (solve(instruction.inputs[0]).toInt() shl instruction.inputs[1].toInt()).toUShort()
            Command.RSHIFT -> (solve(instruction.inputs[0]).toInt() shr instruction.inputs[1].toInt()).toUShort()
        }

        cache[wire] = result
        return result
    }

    val partOne = solve("a")
    answer(2015, 7, 1, partOne)

    // Part 2
    cache.clear()
    cache["b"] = partOne
    val partTwo = solve("a")
    answer(2015, 7, 2, partTwo)
}
