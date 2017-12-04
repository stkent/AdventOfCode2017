import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val validator = PassphraseValidator()
      val part1ValidCount = input.count { validator.isValidNoDuplicates(it) }
      val part2ValidCount = input.count { validator.isValidNoAnagrams(it) }

      println("Part 1 solution: $part1ValidCount")
      println("Part 2 solution: $part2ValidCount")
    }
  }

}
