class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = "183,0,31,146,254,240,223,150,2,206,161,1,255,232,199,88"

      var list = (0..255).toList()
      val lengths = input.split(",").map(String::toInt)

      val hasher = KnotHasher()
      val part1 = hasher.knotWithLengths(list, lengths)

      println(part1[0] * part1[1])
    }
  }

}

fun <E> List<E>.rotate(steps: Int): List<E> {
  val nSteps = steps.nonNegativeRem(size)

  return takeLast(size - nSteps) + take(nSteps)
}