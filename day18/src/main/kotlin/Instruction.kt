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

  data class Snd(val x: Parameter)                            : Instruction()
  data class Set(val x: Parameter.Register, val y: Parameter) : Instruction()
  data class Add(val x: Parameter.Register, val y: Parameter) : Instruction()
  data class Mul(val x: Parameter.Register, val y: Parameter) : Instruction()
  data class Mod(val x: Parameter.Register, val y: Parameter) : Instruction()
  data class Rcv(val x: Parameter.Register)                   : Instruction()
  data class Jgz(val x: Parameter,          val y: Parameter) : Instruction()

  companion object {
    fun parse(s: String): Instruction {
      val split = s.split(' ')

      return when (split[0]) {
        "snd" -> Snd(Parameter.parse(split[1]))
        "set" -> Set(Parameter.parse(split[1]) as Parameter.Register, Parameter.parse(split[2]))
        "add" -> Add(Parameter.parse(split[1]) as Parameter.Register, Parameter.parse(split[2]))
        "mul" -> Mul(Parameter.parse(split[1]) as Parameter.Register, Parameter.parse(split[2]))
        "mod" -> Mod(Parameter.parse(split[1]) as Parameter.Register, Parameter.parse(split[2]))
        "rcv" -> Rcv(Parameter.parse(split[1]) as Parameter.Register)
        "jgz" -> Jgz(Parameter.parse(split[1]), Parameter.parse(split[2]))
        else  -> throw IllegalArgumentException("Unknown instruction: ${split[0]}")
      }
    }
  }
}
