import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val cpu = CPU()
      val instructions = input.map { it.toInt() }
      val part1StepCount = cpu.stepsToExitAdding1(instructions = instructions)
      val part2StepCount = cpu.stepsToExitAddingOrSubtracting1(instructions = instructions)

      println("Part 1 solution: $part1StepCount")
      println("Part 2 solution: $part2StepCount")
    }
  }

}
