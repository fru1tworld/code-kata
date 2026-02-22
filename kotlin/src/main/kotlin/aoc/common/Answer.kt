package aoc.common

private fun formatPrefix(year: Int, day: Int, part: Int? = null): String {
    val dayStr = day.toString().padStart(2, '0')
    val partStr = part?.let { " [Part $it]" }.orEmpty()
    return "[AOC $year] [Day $dayStr]$partStr"
}

fun <T> answer(year: Int, day: Int, part: Int? = null, result: T) {
    println("${formatPrefix(year, day, part)} $result")
}

fun <T> answer(year: Int, day: Int, result: T) {
    answer(year, day, null, result)
}

fun <T> verify(year: Int, day: Int, part: Int? = null, expected: T, actual: T) {
    val status = if (expected == actual) "PASS" else "FAIL (expected: $expected, actual: $actual)"
    println("${formatPrefix(year, day, part)} $status")
}

fun <T> verify(year: Int, day: Int, expected: T, actual: T) {
    verify(year, day, null, expected, actual)
}
