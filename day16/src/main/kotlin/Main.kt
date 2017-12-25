import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines().first().split(",")

      val dance = Dance(initialOrder = "abcdefghijklmnop", rawMoves = input)

      println("Part 1 solution: ${dance.computeFinalOrder(repetitions = 1)}")
      println("Part 2 solution: ${dance.computeFinalOrder(repetitions = 1_000_000_000)}")
    }
  }

}
