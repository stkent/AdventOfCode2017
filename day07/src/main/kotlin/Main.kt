import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val tower = Tower(rawData = input)

      println("Part 1 solution: ${tower.rootProgramName}")
      println("Part 2 solution: ${tower.computeWeightAdjustment()}")
    }

  }

}
