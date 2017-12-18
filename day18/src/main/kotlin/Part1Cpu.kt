class Part1Cpu {

  private val registers = mutableMapOf<Char, Long>().withDefault { 0 }
  private var index = 0
  private var lastSound: Long? = null

  fun findFirstNonZeroRecover(rawInstructions: List<String>): Long {
    val instructions = rawInstructions.map(Instruction.Companion::parse)

    while (true) {
      val it = instructions[index]

      when (it) {
        is Instruction.Snd -> {
          lastSound = resolve(it.x)
          index += 1
        }

        is Instruction.Set -> {
          registers.put(it.x.char, resolve(it.y))
          index += 1
        }

        is Instruction.Add -> {
          registers.put(it.x.char, registers.getValue(it.x.char) + resolve(it.y))
          index += 1
        }

        is Instruction.Mul -> {
          registers.put(it.x.char, registers.getValue(it.x.char) * resolve(it.y))
          index += 1
        }

        is Instruction.Mod -> {
          registers.put(it.x.char, registers.getValue(it.x.char).rem(resolve(it.y)))
          index += 1
        }

        is Instruction.Rcv -> {
          lastSound?.let { return it }
        }

        is Instruction.Jgz -> {
          index += (if (resolve(it.x) > 0) { resolve(it.y) } else { 1 }).toInt()
        }
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
