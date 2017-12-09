import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines().first()
      val processor = StreamProcessor()

      val result = processor.processStream(input)

      println("Part 1 solution: ${result.score}")
      println("Part 2 solution: ${result.garbageCount}")
    }
  }

}
