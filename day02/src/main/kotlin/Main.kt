import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val spreadSheet = Spreadsheet(rawData = input)

      println("Part 1 solution: ${spreadSheet.checksum}")
      println("Part 2 solution: ${spreadSheet.sumOfDivisibleEntries}")
    }
  }

}
