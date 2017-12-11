import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines().first()
      val grid = HexGrid()

      val pathDistances = grid.computeDistances(path = input)

      println("Part 1 solution: ${pathDistances.end}")
      println("Part 2 solution: ${pathDistances.max}")
    }
  }

}
