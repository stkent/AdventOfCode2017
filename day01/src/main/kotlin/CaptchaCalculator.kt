class CaptchaCalculator(private val input: String) {

  private val n = input.length

  fun getSolutionAdjacentPairs(): Int {
    return getSolutionWithOffset(1)
  }

  fun getSolutionOppositePairs(): Int {
    return getSolutionWithOffset(n / 2)
  }

  private fun getSolutionWithOffset(offset: Int): Int {
    return (0 until n)
        .map { Pair(input[it], input[(it + offset).rem(n)]) }
        .filter { it.first == it.second }
        .sumBy { Integer.parseInt("${it.first}") }
  }

}
