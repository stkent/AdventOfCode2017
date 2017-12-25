import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val enhancer = Enhancer(rawTransforms = input)
      val seed = listOf(
          ".#.",
          "..#",
          "###"
      )

      println("Part 1 solution: ${enhancer.enhance(seed = seed, repeats =  5).onCount}")
      println("Part 2 solution: ${enhancer.enhance(seed = seed, repeats = 18).onCount}")
    }
  }

}
