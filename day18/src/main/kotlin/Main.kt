import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      println("Part 1 solution: ${Part1Cpu().findFirstNonZeroRecover(rawInstructions = input)}")
      println("Part 2 solution: ${Part2Coordinator().performDuet(rawInstructions = input)}")
    }
  }

}
