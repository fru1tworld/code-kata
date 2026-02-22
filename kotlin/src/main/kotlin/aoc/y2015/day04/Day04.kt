package aoc.y2015.day04

import aoc.common.answer
import aoc.common.input
import java.security.MessageDigest

fun main() {
    val secretKey = input(2015, 4)

    val part1 = findLowestNumber(secretKey, "00000")
    answer(2015, 4, 1, part1)

    val part2 = findLowestNumber(secretKey, "000000")
    answer(2015, 4, 2, part2)
}

fun findLowestNumber(key: String, prefix: String): Int {
    val md = MessageDigest.getInstance("MD5")

    return (0..Int.MAX_VALUE)
        .first { number ->
            val origin = "$key$number"
            val digest = md.digest(origin.toByteArray())
            digest.toHexString().startsWith(prefix)
        }
}

fun ByteArray.toHexString(): String = joinToString("") { "%02x".format(it) }