package aoc.y2015.day06

data class Point(val x: Int, val y: Int)
data class Region(val from: Point, val to: Point)

enum class Action { TurnOn, TurnOff, Toggle }

data class Instruction(val action: Action, val region: Region)

object InstructionParser {
    private val pattern = Regex("""(turn on|turn off|toggle) (\d+),(\d+) through (\d+),(\d+)""")

    fun parse(line: String): Instruction {
        val match = pattern.find(line) ?: error("Unknown format: $line")
        val (action, x1, y1, x2, y2) = match.destructured
        val region = Region(Point(x1.toInt(), y1.toInt()), Point(x2.toInt(), y2.toInt()))

        val actionEnum = when (action) {
            "turn on" -> Action.TurnOn
            "turn off" -> Action.TurnOff
            "toggle" -> Action.Toggle
            else -> error("Unknown action: $action")
        }
        return Instruction(actionEnum, region)
    }
}
