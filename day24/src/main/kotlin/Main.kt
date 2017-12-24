import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()
      val builder = BridgeBuilder(input)

      println("Part 1 solution: ${builder.strongestBridge().strength}")
      println("Part 2 solution: ${builder.strongestLongestBridge().strength}")
    }
  }

}
