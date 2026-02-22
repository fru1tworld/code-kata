package aoc.y2015.day07

enum class Command {
    AND, OR, LSHIFT, RSHIFT, NOT, ASSIGN
}

data class Instruction(
    val command: Command,
    val inputs: List<String>,
    val destination: String
)

object InstructionParser {
    private val binOp = Regex("""^(\w+) (AND|OR|LSHIFT|RSHIFT) (\w+) -> (\w+)$""")
    private val notOp = Regex("""^NOT (\w+) -> (\w+)$""")
    private val assignOp = Regex("""^(\w+) -> (\w+)$""")

    fun parse(line: String): Instruction {
        return when {
            binOp.matches(line) -> {
                val match = binOp.find(line)!!
                val (in1, op, in2, dest) = match.destructured
                Instruction(Command.valueOf(op), listOf(in1, in2), dest)
            }
            notOp.matches(line) -> {
                val match = notOp.find(line)!!
                val (in1, dest) = match.destructured
                Instruction(Command.NOT, listOf(in1), dest)
            }
            assignOp.matches(line) -> {
                val match = assignOp.find(line)!!
                val (in1, dest) = match.destructured
                Instruction(Command.ASSIGN, listOf(in1), dest)
            }
            else -> throw IllegalArgumentException("Unknown format: $line")
        }
    }
}