class CPU {

  fun stepsToExitAdding1(instructions: List<Int>): Int {
    return stepsToExit(instructions, offsetChange = { 1 })
  }

  fun stepsToExitAddingOrSubtracting1(instructions: List<Int>): Int {
    return stepsToExit(instructions, offsetChange = { if (it >= 3) -1 else 1 })
  }

  private fun stepsToExit(instructions: List<Int>, offsetChange: (oldOffset: Int) -> Int): Int {
    val mutableInstructions = instructions.toMutableList()

    var index = 0
    var result = 0

    while (index in 0 until instructions.size) {
      val offset = mutableInstructions[index]

      mutableInstructions[index] = mutableInstructions[index] + offsetChange(offset)
      index += offset

      result += 1
    }

    return result
  }

}
