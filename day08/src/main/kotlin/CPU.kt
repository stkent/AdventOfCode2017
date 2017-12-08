import kotlin.math.max

class CPU {

  private data class Instruction(
      val targetReg: String,
      val op: Op,
      val value: Int,
      val compLhsReg: String,
      val comparison: Comparison,
      val compRhsVal: Int) {

    enum class Comparison(val binOp: (Int, Int) -> Boolean) {
      GT( { a, b -> a > b }),
      GTE({ a, b -> a >= b }),
      EQ( { a, b -> a == b }),
      LT( { a, b -> a < b }),
      LTE({ a, b -> a <= b }),
      NEQ({ a, b -> a != b });

      companion object {
        fun fromString(string: String): Comparison? {
          return when (string) {
            ">"  -> GT
            ">=" -> GTE
            "==" -> EQ
            "<"  -> LT
            "<=" -> LTE
            "!=" -> NEQ
            else -> null
          }
        }
      }
    }

    enum class Op(val binOp: (Int, Int) -> Int) {
      INC({ a, b -> a + b}),
      DEC({ a, b -> a - b});

      companion object {
        fun fromString(string: String): Op? {
          return when (string) {
            "inc" -> INC
            "dec" -> DEC
            else  -> null
          }
        }
      }
    }

    fun shouldExecute(lhs: Int) = comparison.binOp(lhs, compRhsVal)
  }

  data class ExecutionResult(val maxEndValue: Int, val maxExecValue: Int)

  private val registers = mutableMapOf<String, Int>().withDefault { 0 }

  fun execute(rawInstructions: List<String>): ExecutionResult {
    val regex = Regex("^(\\w+) (inc|dec) (-?\\d+) if (\\w+) ([^ ]+) (-?\\d+)$")

    val instructions = rawInstructions.map { string ->
      val components = regex.matchEntire(string)!!.groupValues.drop(1)

      return@map Instruction(
          targetReg  = components[0],
          op         = Instruction.Op.fromString(components[1])!!,
          value      = components[2].toInt(),
          compLhsReg = components[3],
          comparison = Instruction.Comparison.fromString(components[4])!!,
          compRhsVal = components[5].toInt())
    }

    var maxExecValue = 0

    instructions.forEach { instruction ->
      if (instruction.shouldExecute(registers.getValue(instruction.compLhsReg))) {
        val currVal = registers.getValue(instruction.targetReg)
        registers.put(instruction.targetReg, instruction.op.binOp(currVal, instruction.value))
      }

      maxExecValue = max(maxExecValue, registers.values.max()!!)
    }

    val maxEndValue = registers.values.max()!!
    return ExecutionResult(maxEndValue, maxExecValue)
  }

}
