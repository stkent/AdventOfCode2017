import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val machine = TuringMachine(blueprint = input)

      println("Part 1 solution: ${machine.computeChecksum()}")
    }
  }

}
