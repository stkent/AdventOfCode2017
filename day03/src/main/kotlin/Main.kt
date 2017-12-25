class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = 277678

      val memory = SpiralMemory()

      println("Part 1 solution: ${memory.getDistanceToAddress(address = input)}")
      println("Part 2 solution: ${memory.getFirstStressTestValueExceeding(threshold = input)}")
    }
  }

}
