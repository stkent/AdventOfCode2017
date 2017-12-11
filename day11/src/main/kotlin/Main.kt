import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines().first()
      val visitedPoints = input.split(',')
                               .mapNotNull { HexDirection.fromString(it) }
                               .accumulate(HexGridPoint(0, 0, 0)) { acc, dir -> acc.step(dir) }

      val origin = HexGridPoint(0, 0, 0)

      println("Part 1 solution: ${visitedPoints.last().distanceTo(origin)}")
      println("Part 2 solution: ${visitedPoints.map { it.distanceTo(origin) }.max()}")
    }
  }

}
