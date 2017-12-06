class MemoryCyclingDebugger {

  data class Result(val cyclesToRepeat: Int, val loopLength: Int)

  fun debug(initialConfig: Config): Result {
    val configs = mutableListOf<Config>()
    var config = initialConfig

    while (true) {
      config = config.cycle()

      if (configs.contains(config)) {
        val cyclesToRepeat = configs.size + 1
        val loopLength = configs.size - configs.indexOfFirst { it == config }
        return Result(cyclesToRepeat, loopLength)
      }

      configs.add(config)
    }
  }

  private fun Config.cycle(): Config {
    val result = toMutableList()

    val max = result.max()!!
    val indexToRedistribute = indexOfFirst { it == max }

    result[indexToRedistribute] = 0

    var toDistribute = max
    var startIndex = (indexToRedistribute + 1).rem(size)

    while (toDistribute > 0) {
      result[startIndex] = result[startIndex] + 1
      startIndex = (startIndex + 1).rem(size)
      toDistribute -= 1
    }

    return result
  }

}
