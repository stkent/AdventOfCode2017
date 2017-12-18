class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = 329
      val stopper = SpinLockStopper()

      println("Part 1 solution: ${stopper.computeValueAfterLastInsert(input, 2017)}")
      println("Part 2 solution: ${stopper.computeValueAfterZero(input, 50000000)}")
    }
  }

}
