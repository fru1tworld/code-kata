package aoc.y2015.day05

import aoc.common.answer
import aoc.common.inputLinesNotBlank

fun main() {
    val input = inputLinesNotBlank(2015, 5)

    val part1 = input.count { it.isNicePart1() }
    answer(2015, 5, 1, part1)

    val part2 = input.count { it.isNicePart2() }
    answer(2015, 5, 2, part2)
}

private val vowels = setOf('a', 'e', 'i', 'o', 'u')
private val forbidden = listOf("ab", "cd", "pq", "xy")

private fun String.hasAtLeastThreeVowels(): Boolean =
    count { it in vowels } >= 3

private fun String.hasDoubleLetter(): Boolean =
    zipWithNext().any { (a, b) -> a == b }

private fun String.hasNoForbidden(): Boolean =
    forbidden.none { it in this }

private fun String.isNicePart1(): Boolean =
    hasAtLeastThreeVowels() && hasDoubleLetter() && hasNoForbidden()

private fun String.hasPairTwice(): Boolean =
    (0 until length - 1).any { i ->
        substring(i, i + 2) in substring(i + 2)
    }

private fun String.hasRepeatWithGap(): Boolean =
    (0 until length - 2).any { i -> this[i] == this[i + 2] }

private fun String.isNicePart2(): Boolean =
    hasPairTwice() && hasRepeatWithGap()
