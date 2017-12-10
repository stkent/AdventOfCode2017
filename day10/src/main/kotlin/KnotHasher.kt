class KnotHasher {

  fun knotWithLengths(inList: List<Int>, lengths: List<Int>): List<Int> {
    var index = 0
    var skip = 0
    var currentList = inList

    for (length in lengths) {
      val rotatedList = currentList.rotate(index)
      val elementsToReverse = rotatedList.take(length)
      val reversedElements = elementsToReverse.reversed()
      val rotatedResult = reversedElements + rotatedList.drop(length)

      currentList = rotatedResult.rotate(-index)

      index = (index + length + skip).rem(inList.size)
      skip += 1
    }

    return currentList
  }

}