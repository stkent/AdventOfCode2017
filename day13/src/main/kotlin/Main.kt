import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val firewall = Firewall(scannerInfo = input)

      println("Part 1 solution: ${firewall.scoreForDelay(0)}")
      println("Part 2 solution: ${firewall.firstEscapeDelay()}")
    }
  }

}
