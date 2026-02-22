package aoc.common

import kotlin.io.path.readText
import kotlin.io.path.toPath

/**
 * Advent of Code Input File Reader
 */
object InputReader {
    fun read(
        year: Int,
        day: Int,
    ): String {
        val dayStr = day.toString().padStart(2, '0')
        val path = "$year/day$dayStr/input.txt"
        val resource =
            Thread.currentThread().contextClassLoader.getResource(path)
                ?: throw IllegalArgumentException("Input file not found: $path")
        return resource
            .toURI()
            .toPath()
            .readText()
            .trim()
    }

    fun readLines(
        year: Int,
        day: Int,
    ): List<String> = read(year, day).lines()

    fun readLinesNotBlank(
        year: Int,
        day: Int,
    ): List<String> = readLines(year, day).filter { it.isNotBlank() }

    fun readInts(
        year: Int,
        day: Int,
    ): List<Int> = readLinesNotBlank(year, day).map { it.toInt() }

    fun readLongs(
        year: Int,
        day: Int,
    ): List<Long> = readLinesNotBlank(year, day).map { it.toLong() }
}

fun input(
    year: Int,
    day: Int,
): String = InputReader.read(year, day)

fun inputLines(
    year: Int,
    day: Int,
): List<String> = InputReader.readLines(year, day)

fun inputLinesNotBlank(
    year: Int,
    day: Int,
): List<String> = InputReader.readLinesNotBlank(year, day)
