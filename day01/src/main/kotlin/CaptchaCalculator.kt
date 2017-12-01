class CaptchaCalculator(private val input: String) {

  private val n = input.length

  fun getSolutionAdjacentPairs(): Int {
    return (0 until n)
        .map { Pair(input[it], input[(it + 1).rem(n)]) }
        .filter { it.first == it.second }
        .map { Integer.parseInt("${it.first}") }
        .sum()
  }

  fun getSolutionOppositePairs(): Int {
    return (0 until n)
        .map { Pair(input[it], input[(it + n / 2).rem(n)]) }
        .filter { it.first == it.second }
        .map { Integer.parseInt("${it.first}") }
        .sum()
  }

}
