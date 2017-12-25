import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val cpu = Part1Cpu()

      println("Part 1 solution: ${cpu.countMultiplications(rawInstructions = input)}")

      // See PART2.md for calculations:
      println("Part 2 solution: ${(105700..122700 step 17).count(Int::isNotPrime)}")
    }
  }

}
