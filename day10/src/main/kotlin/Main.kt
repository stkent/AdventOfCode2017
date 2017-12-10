class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = "183,0,31,146,254,240,223,150,2,206,161,1,255,232,199,88"

      var list = (0..255).toList()
//      var list = listOf(0, 1, 2, 3, 4)
      var index = 0
      var skip = 0
      val lengths = input.split(",").map(String::toInt)
//      val lengths = listOf(3, 4, 1, 5)

      for (length in lengths) {
        val rotatedList = list.rotate(index)
        val elementsToReverse = rotatedList.take(length)
        val reversedElements = elementsToReverse.reversed()
        val listToRotate = reversedElements + rotatedList.drop(length)
        list = listToRotate.rotate(-index)
        index = (index + length + skip).rem(list.size)
        skip += 1
      }

      println(list[0] * list[1])
    }
  }

}

fun <E> List<E>.rotate(steps: Int): List<E> {
  val nSteps = steps.nonNegativeRem(size)

  return takeLast(size - nSteps) + take(nSteps)
}