// Adapted from day 18 solution:
sealed class Instruction {

  sealed class Parameter {
    data class Register(val char: Char) : Parameter() {
      override fun toString() = char.toString()
    }

    data class Value(val raw: Long) : Parameter() {
      override fun toString() = raw.toString()
    }

    companion object {
      fun parse(s: String) = if (s.isLong()) Value(s.toLong()) else Register(s.first())
    }
  }

  data class Set(val x: Parameter.Register, val y: Parameter) : Instruction()
  data class Sub(val x: Parameter.Register, val y: Parameter) : Instruction()
  data class Mul(val x: Parameter.Register, val y: Parameter) : Instruction()
  data class Jnz(val x: Parameter,          val y: Parameter) : Instruction()

  companion object {
    fun parse(s: String): Instruction {
      val split = s.split(' ')

      return when (split[0]) {
        "set" -> Set(Parameter.parse(split[1]) as Parameter.Register, Parameter.parse(split[2]))
        "sub" -> Sub(Parameter.parse(split[1]) as Parameter.Register, Parameter.parse(split[2]))
        "mul" -> Mul(Parameter.parse(split[1]) as Parameter.Register, Parameter.parse(split[2]))
        "jnz" -> Jnz(Parameter.parse(split[1]), Parameter.parse(split[2]))
        else  -> throw IllegalArgumentException("Unknown instruction: ${split[0]}")
      }
    }
  }
}
