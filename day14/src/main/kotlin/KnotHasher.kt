data class KnotResult(val list: List<Int>, val index: Int, val skip: Int)

class KnotHasher {

  fun hash(bytes: String): String {
    val lengths = bytes.map(Char::toInt) + listOf(17, 31, 73, 47, 23)

    var list  = (0..255).toList()
    var index = 0
    var skip  = 0

    repeat(64) {
      val result = knot(lengths, list, index, skip)
      list  = result.list
      index = result.index
      skip  = result.skip
    }

    val sparseHash = list
    val denseHash = sparseHash.chunked(16).map { it.reduce { i, j -> i xor j } }
    val finalHash = denseHash.map { "%02x".format(0xFF and it) }

    return finalHash.joinToString(separator = "")
  }

  fun knot(
      lengths: List<Int>,
      inList:  List<Int> = (0..255).toList(),
      inIndex: Int = 0,
      inSkip:  Int = 0): KnotResult {

    var list  = inList
    var index = inIndex
    var skip  = inSkip

    for (length in lengths) {
      val rotatedList = list.rotate(index)
      val elementsToReverse = rotatedList.take(length)
      val reversedElements = elementsToReverse.reversed()
      val rotatedResult = reversedElements + rotatedList.drop(length)

      list = rotatedResult.rotate(-index)

      index = (index + length + skip).rem(inList.size)
      skip += 1
    }

    return KnotResult(list, index, skip)
  }

}