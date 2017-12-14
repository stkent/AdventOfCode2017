class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = "xlqgujun"
      val disk = Disk(key = input)

      println("Part 1 solution: ${disk.countUsedSquares()}")
      println("Part 2 solution: ${disk.countGroups()}")
    }
  }

}
