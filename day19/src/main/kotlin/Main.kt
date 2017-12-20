import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()
      val router = Router()

      val result = router.route(input)

      println("Part 1 solution: ${result.chars}")
      println("Part 2 solution: ${result.nSteps}")
    }
  }

}
