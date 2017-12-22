import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      println("Part 1 solution: ${BasicVirus().countInfections(rawMap = input, repeats = 10000)}")
      println("Part 2 solution: ${EvolvedVirus().countInfections(rawMap = input, repeats = 10000000)}")
    }
  }

}
