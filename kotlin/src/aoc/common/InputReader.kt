package aoc.common

import java.io.File

/**
 * Advent of Code Input File Reader
 */
object InputReader {
    private val projectRoot: File by lazy {
        var dir = File(System.getProperty("user.dir"))
        while (dir.parentFile != null) {
            if (File(dir, "inputs").exists()) {
                return@lazy dir
            }
            dir = dir.parentFile
        }
        File(System.getProperty("user.dir"))
    }

    fun read(
        year: Int,
        day: Int,
    ): String {
        val dayStr = day.toString().padStart(2, '0')
        val path = "inputs/$year/day$dayStr/input.txt"
        val file = File(projectRoot, path)
        require(file.exists()) { "Input file not found: ${file.absolutePath}" }
        return file.readText().trim()
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
