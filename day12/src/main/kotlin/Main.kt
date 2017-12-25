import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val graphGrouper = GraphGrouper()
      val groups = graphGrouper.computeGroups(pipeStrings = input)
      val group0 = groups.first { group -> group.contains(0) }

      println("Part 1 solution: ${group0.count()}")
      println("Part 2 solution: ${groups.count()}")
    }
  }

}
