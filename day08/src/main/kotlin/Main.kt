import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()
      val cpu = CPU()

      val result = cpu.execute(input)

      println("Part 1 solution: ${result.maxEndValue}")
      println("Part 2 solution: ${result.maxExecValue}")
    }
  }

}
