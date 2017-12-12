import java.io.File

typealias Pipe = Pair<Int, Int>

class Main {

  companion object {
    private val inputRegex = Regex("^(\\d+) <-> (.*)$")

    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      // bug: this is required here
      val pipes = input.flatMap(this::stringToPipes)
                       .groupBy(Pipe::first) { pipe -> pipe.second }

      println(pipes)
    }

    private fun stringToPipes(string: String): List<Pipe> {
      val groups = inputRegex.matchEntire(string)!!.groupValues.drop(1)

      val startPipe = groups[0].toInt()
      val endPipes  = groups[1].split(", ").map(String::toInt)

      return endPipes.map { Pair(startPipe, it) }
    }
  }

}
