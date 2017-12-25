class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = 329

      val stopper = SpinLockStopper()

      println("Part 1 solution: ${stopper.computeValueAfterLastInsert(stepSize = input, insertCount = 2017)}")
      println("Part 2 solution: ${stopper.computeValueAfterZero(stepSize = input, insertCount = 50_000_000)}")
    }
  }

}
