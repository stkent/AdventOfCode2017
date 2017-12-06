typealias Config = List<Int>

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = listOf(11, 11, 13, 7, 0, 15, 5, 5, 4, 4, 1, 1, 7, 1, 15, 11)
      val debugger = MemoryCyclingDebugger()

      val result = debugger.debug(initialConfig = input)

      println("Part 1 solution: ${result.cyclesToRepeat}")
      println("Part 2 solution: ${result.loopLength}")
    }
  }

}
