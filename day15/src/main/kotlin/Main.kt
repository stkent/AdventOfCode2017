import Generator.GeneratorA
import Generator.GeneratorB

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val judge = Judge()

      val part1GeneratorA = GeneratorA(seed = 722, accept = { true })
      val part1GeneratorB = GeneratorB(seed = 354, accept = { true })

      println("Part 1 solution: ${judge.countMatches(part1GeneratorA, part1GeneratorB, 40_000_000)}")

      val part2GeneratorA = GeneratorA(seed = 722, accept = { it.rem(4) == 0L })
      val part2GeneratorB = GeneratorB(seed = 354, accept = { it.rem(8) == 0L })

      println("Part 2 solution: ${judge.countMatches(part2GeneratorA, part2GeneratorB, 5_000_000)}")
    }
  }

}
