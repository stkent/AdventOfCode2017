import Instruction.*
import Instruction.Set

// Adapted from day 18 solution:
class Part1Cpu {

  private val registers = mutableMapOf<Char, Long>().withDefault { 0 }
  private var index = 0

  fun countMultiplications(rawInstructions: List<String>): Int {
    val instructions = rawInstructions.map(Instruction.Companion::parse)
    var count = 0

    while (index >= 0 && index < instructions.size) {
      val it = instructions[index]

      when (it) {
        is Set -> {
          registers.put(it.x.char, resolve(it.y))
          index += 1
        }

        is Sub -> {
          registers.put(it.x.char, registers.getValue(it.x.char) - resolve(it.y))
          index += 1
        }

        is Mul -> {
          registers.put(it.x.char, registers.getValue(it.x.char) * resolve(it.y))
          index += 1
          count += 1
        }

        is Jnz -> {
          index += (if (resolve(it.x) != 0L) { resolve(it.y) } else { 1 }).toInt()
        }

      }
    }

    return count
  }

  private fun resolve(p: Instruction.Parameter): Long {
    return when (p) {
      is Instruction.Parameter.Value    -> p.raw
      is Instruction.Parameter.Register -> registers.getValue(p.char)
    }
  }

}
