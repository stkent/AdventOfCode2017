import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val registers = mutableMapOf<Char, Long>()

      ('a'..'z').forEach { registers.put(it, 0) }

      var index = 0
      var run = true

      var lastSound: Long = -1

      while (run) {
        val it = input[index]

        val type = it.substring(0, 3)
        val args = it.substring(4).split(' ')

        println("$index: $it: $registers")

        when (type) {

          "snd" -> {
            lastSound = registers[args[0][0]]!!

            index += 1
          }

          "set" -> {
            val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

            registers.put(args[0][0], value)

            index += 1
          }

          "add" -> {
            val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

            registers.put(args[0][0], registers[args[0][0]]!! + value)

            index += 1
          }

          "mul" -> {
            val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

            println(args)
            registers.put(args[0][0], registers[args[0][0]]!! * value)

            index += 1
          }

          "mod" -> {
            val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

            registers.put(args[0][0], registers[args[0][0]]!!.rem(value))

            index += 1
          }

          "rcv" -> {
            val value = if (args[0][0].isLetter()) registers[args[0][0]]!! else args[0].toLong()

            if (value > 0) {
              println("part 1: $lastSound")
              run = false
            }

            index += 1
          }

          "jgz" -> {
            val value0 = if (args[0][0].isLetter()) registers[args[0][0]]!! else args[0].toLong()
            val value1 = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

            index += (if (value0 > 0L) { value1 } else { 1L }).toInt()
          }
        }

        if (index < 0 || index >= input.size) run = false
      }
    }
  }

}