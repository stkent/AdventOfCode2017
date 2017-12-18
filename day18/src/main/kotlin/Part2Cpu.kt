import java.util.*

class Part2Cpu(
    id: Long,
    private val inQueue: Queue<Long>,
    private val outQueue: Queue<Long>) {

  var sentMessageCount: Int = 0

  private val registers = mutableMapOf<Char, Long>().withDefault { 0 }
  private var index = 0
  private lateinit var instructions: List<Instruction>

  init { registers['p'] = id }

  fun setInstructions(rawInstructions: List<String>) {
    instructions = rawInstructions.map(Instruction.Companion::parse)
  }

  fun maybeExecuteNext(): Boolean {
    if (index !in 0 until instructions.size) return false

    val it = instructions[index]

    when (it) {
      is Instruction.Snd -> {
        outQueue.add(resolve(it.x))
        sentMessageCount += 1
        index += 1
        return true
      }

      is Instruction.Set -> {
        registers.put(it.x.char, resolve(it.y))
        index += 1
        return true
      }

      is Instruction.Add -> {
        registers.put(it.x.char, registers.getValue(it.x.char) + resolve(it.y))
        index += 1
        return true
      }

      is Instruction.Mul -> {
        registers.put(it.x.char, registers.getValue(it.x.char) * resolve(it.y))
        index += 1
        return true
      }

      is Instruction.Mod -> {
        registers.put(it.x.char, registers.getValue(it.x.char).rem(resolve(it.y)))
        index += 1
        return true
      }

      is Instruction.Rcv -> {
        if (inQueue.isNotEmpty()) {
          registers.put(it.x.char, inQueue.poll())
          index += 1
          return true
        } else {
          return false
        }
      }

      is Instruction.Jgz -> {
        index += (if (resolve(it.x) > 0) { resolve(it.y) } else { 1 }).toInt()
        return true
      }
    }
  }

  private fun resolve(p: Instruction.Parameter): Long {
    return when (p) {
      is Instruction.Parameter.Value    -> p.raw
      is Instruction.Parameter.Register -> registers.getValue(p.char)
    }
  }

}
