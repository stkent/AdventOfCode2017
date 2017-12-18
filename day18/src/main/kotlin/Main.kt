import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

//      val input = listOf(
//          "snd 1",
//          "snd 2",
//          "snd p",
//          "rcv a",
//          "rcv b",
//          "rcv c",
//          "rcv d"
//      )
//
      val coord = Coordinator()
      coord.executeInstructions(input)
    }
  }

}

sealed class Result {
  class Success : Result()
  class Send(val send: Long) : Result()
  class Termination : Result()
  class SoundRequired : Result()
}

class Coordinator {

  private val computers = mapOf(0 to Computer(0), 1 to Computer(1))

  fun executeInstructions(instructions: List<String>) {
    val executingComputers = computers.toMutableMap()
    val soundsToTransfer = mutableListOf<Long>()

    computers.values.forEach { it.instructions = instructions }
    var executingComputer = 0

    var soln = 0

    var waiting = false

    loop@ while (true) {
//      Thread.sleep(1000)

      val result = computers[executingComputer]!!.executeNext()

      when (result) {
        is Result.Success -> waiting = false
        is Result.Send -> {
          waiting = false
          if (executingComputer == 1) soln++
          soundsToTransfer.add(result.send)
        }
//        is Result.Termination -> {
//          executingComputers.remove(executingComputer)
//
//          if (executingComputers.isEmpty()) {
//            break@loop
//          }
//        }
        is Result.SoundRequired -> {
          if (waiting) {
            println(soln)
            break@loop
          } else {
            waiting = true
          }
          executingComputer = (executingComputer + 1).rem(2)
          executingComputers[executingComputer]!!.enqueueSounds(soundsToTransfer)
          soundsToTransfer.clear()
        }
      }
    }
  }

}

class Computer(private val id: Long) {

  private val registers = mutableMapOf<Char, Long>()
  private val receivedSounds = mutableListOf<Long>()
  private var index = 0

  lateinit var instructions: List<String>

  init {
    ('a'..'z').forEach { registers.put(it, 0) }
    registers['p'] = id
  }

  fun enqueueSounds(sounds: List<Long>) {
    receivedSounds.addAll(sounds)
  }

  fun executeNext(): Result {
    val it = instructions[index]

    val type = it.substring(0, 3)
    val args = it.substring(4).split(' ')

    println("id $id | instr: $index: $it | registers: $registers")

    when (type) {
      "snd" -> {
        val value = if (args[0][0].isLetter()) registers[args[0][0]]!! else args[0].toLong()

        index += 1
        return if (index < 0 || index >= instructions.size) Result.Termination() else return Result.Send(value)
      }

      "set" -> {
        val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

        registers.put(args[0][0], value)

        index += 1
        return if (index < 0 || index >= instructions.size) Result.Termination() else return Result.Success()
      }

      "add" -> {
        val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

        registers.put(args[0][0], registers[args[0][0]]!! + value)

        index += 1
        return if (index < 0 || index >= instructions.size) Result.Termination() else return Result.Success()
      }

      "mul" -> {
        val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

        println(args)
        registers.put(args[0][0], registers[args[0][0]]!! * value)

        index += 1
        return if (index < 0 || index >= instructions.size) Result.Termination() else return Result.Success()
      }

      "mod" -> {
        val value = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

        registers.put(args[0][0], registers[args[0][0]]!!.rem(value))

        index += 1
        return if (index < 0 || index >= instructions.size) Result.Termination() else return Result.Success()
      }

      "rcv" -> {
        if (receivedSounds.isNotEmpty()) {
          registers.put(args[0][0], receivedSounds.first())
          receivedSounds.removeAt(0)
          index += 1
          return if (index < 0 || index >= instructions.size) Result.Termination() else return Result.Success()
        } else {
          return Result.SoundRequired()
        }
      }

      "jgz" -> {
        val value0 = if (args[0][0].isLetter()) registers[args[0][0]]!! else args[0].toLong()
        val value1 = if (args[1][0].isLetter()) registers[args[1][0]]!! else args[1].toLong()

        index += (if (value0 > 0L) { value1 } else { 1L }).toInt()

        return if (index < 0 || index >= instructions.size) Result.Termination() else Result.Success()
      }

      else -> throw IllegalArgumentException()
    }
  }

}